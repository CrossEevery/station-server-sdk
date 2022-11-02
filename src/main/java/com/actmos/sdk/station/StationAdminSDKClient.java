package com.actmos.sdk.station;

import com.actmos.sdk.station.config.AdminUrlConfig;
import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.page.SdkReqPage;
import com.actmos.sdk.station.dto.page.StdPagedList;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.*;
import com.actmos.sdk.station.transfer.format.*;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

/**
 * Station Server SDK
 */
public class StationAdminSDKClient implements Serializable {

    private StationConfig config;
    private CrossTransfer crossTransfer;

    public StationAdminSDKClient(StationConfig config) {
        this.config=config;
        Preconditions.checkNotNull(this.config, "SDK配置不能为空");
        Preconditions.checkNotNull(this.config.getEndpoint(), "访问请求不能为空");
        Preconditions.checkNotNull(this.config.getKey(), "SDK KEY不能为空");
        Preconditions.checkNotNull(this.config.getSecurity(), "SDK SECURITY不能为空");
        this.crossTransfer = new CrossTransfer(new TransferSign(config), true);
    }

    /**
     * 分页获取租户下面的用户列表
     * @param page
     * @return
     */
    public StdPagedList<StationUserDTO> getStationUserByPage(SdkReqPage page){

        return null;
    }

    /**
     * 获取SDK KEY关联下的Station
     *
     * @param page
     * @return
     */
    public StdPagedList<StationDTO> getStationsByPage(SdkReqPage page) {

        return null;
    }

    /**
     * 申请一个上传文件的授权
     *
     * @return
     */
    public UploadTokenDTO applyUploadToken() throws IOException, StationException {
        UploadTokenDTO rs = null;
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.UPLOAD_TOKEN, null);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.GET, null);
        CrossResponse httpResponse = this.crossTransfer.getTransfer(httpRequest, new UploadTokenDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (UploadTokenDTO) httpResponse.getData();
        }
        return rs;
    }


    /**
     * 上传文件
     *
     * @param file
     * @param uploadToken
     * @return
     */
    public String uploadFile(String file, UploadTokenDTO uploadToken) throws StationException {
        COSCredentials cred = new BasicCOSCredentials(uploadToken.getResponse().credentials.tmpSecretId, uploadToken.getResponse().credentials.tmpSecretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(uploadToken.getRegion()));
        COSClient cosclient = new COSClient(cred, clientConfig);
        String bucketName = uploadToken.getBucketName();
        File localFile = new File(file);
        if (!localFile.exists()) {
            throw new StationException("本地文件不存在");
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, uploadToken.getFilePath(), localFile);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setSecurityToken(uploadToken.getResponse().credentials.sessionToken);
        putObjectRequest.setMetadata(objectMetadata);
        String etag = null;
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            etag = putObjectResult.getETag();
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }
        cosclient.shutdown();
        return etag;
    }

    /**
     * 将上传的文件申请成为一个可发布的模板
     *
     * @param template
     * @return
     */
    public StationTrilateralTemplateDTO applyStationTrilateralTemplate(StationTrilateralTemplateDTO template) throws Exception {
        Preconditions.checkNotNull(template, "入参不能为空");
        Preconditions.checkNotNull(template.getPublishStartTime(), "生效开始时间不能为空");
        Preconditions.checkNotNull(template.getPublishEndTime(), "生效结束时间不能为空");
        Preconditions.checkNotNull(template.getName(), "模板名称不能为空");
        Preconditions.checkNotNull(template.getInfo(), "模板描述不能为空");
        Preconditions.checkNotNull(template.getTag(), "模板标签不能为空");
        Preconditions.checkNotNull(template.getPhoto128(), "模板默认图片不能为空");
        Preconditions.checkNotNull(template.getProjectPath(), "模板应用上传路徑不能为空");
        Preconditions.checkArgument(template.getStock() > 0, "模板库存不能小于0");
        StationTrilateralTemplateDTO rs = null;
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.TEMPLATE_APPLY, null);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.POST, template);
        CrossResponse httpResponse = this.crossTransfer.postTransfer(httpRequest, new StationTrilateralTemplateDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (StationTrilateralTemplateDTO) httpResponse.getData();
        }
        return rs;
    }

    /**
     * 将模板上架
     *
     * @param tid
     * @return
     */
    public StationTrilateralTemplateDTO enableStationTrilateralTemplate(long tid) throws IOException, StationException {
        Preconditions.checkArgument(tid > 0, "模板不存在");
        StationTrilateralTemplateDTO rs = null;
        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("tid", String.valueOf(tid));
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.TEMPLATE_ENABLE, parameter);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.GET, parameter);
        CrossResponse httpResponse = this.crossTransfer.getTransfer(httpRequest, new StationTrilateralTemplateDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (StationTrilateralTemplateDTO) httpResponse.getData();
        }
        return rs;
    }

    /**
     * 将模板下架
     *
     * @param tid
     * @return
     */
    public StationTrilateralTemplateDTO disableStationTrilateralTemplate(long tid) throws IOException, StationException {
        Preconditions.checkArgument(tid > 0, "模板不存在");
        StationTrilateralTemplateDTO rs = null;
        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("tid", String.valueOf(tid));
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.TEMPLATE_DISABLE, parameter);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.GET, parameter);
        CrossResponse httpResponse = this.crossTransfer.getTransfer(httpRequest, new StationTrilateralTemplateDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (StationTrilateralTemplateDTO) httpResponse.getData();
        }
        return rs;
    }

    /**
     * 将模板授权给一个用户
     *
     * @param tid
     * @param openUUID
     * @return
     */
    public EnshrineDTO grantTemplateToUser(long tid, String openUUID) throws IOException, StationException {
        Preconditions.checkArgument(tid > 0, "模板不存在");
        Preconditions.checkNotNull(openUUID, "OpenUUID不能为空");
        EnshrineDTO rs = null;
        Map<String, String> parameter = Maps.newHashMap();
        parameter.put("tid", String.valueOf(tid));
        parameter.put("uuid", openUUID);
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.ENSHRINE_GRANT, parameter);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.GET, parameter);
        CrossResponse httpResponse = this.crossTransfer.getTransfer(httpRequest, new EnshrineDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (EnshrineDTO) httpResponse.getData();
        }
        return rs;
    }

    /**
     * 使用模板创建一个空间站
     *
     * @param station
     * @return
     */
    public StationDTO createStation(StationDTO station) throws Exception {
        Preconditions.checkNotNull(station, "空间信息不能为空");
        Preconditions.checkNotNull(station.getName(), "空间站名称不对为空");
        Preconditions.checkNotNull(station.getStationDesc(), "空间站的描述不能为空");
        Preconditions.checkNotNull(station.getTags(), "空间站的标签不能为空");
        Preconditions.checkNotNull(station.getStationPhoto(), "空间站的1号图片不能为空");
        Preconditions.checkArgument(station.getHubType() > 0, "请选择空间站的HUD");
        Preconditions.checkArgument(station.getAudioType() > 0, "请选择空间站的音频模式");
        Preconditions.checkArgument(station.getDeliveryType() > 0, "请选择空间站的传送模式");
        Preconditions.checkArgument(station.getPropertiesType() > 0, "请选择空间站的道具模式");
        Preconditions.checkArgument(station.getUserMode() > 0, "请选择空间站的用户模式");
        Preconditions.checkArgument(station.getEnshrineId() > 0, "空间站模板ID不能为空");
        StationDTO rs = null;
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.STATION_CREATE, null);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.POST, station);
        CrossResponse httpResponse = this.crossTransfer.postTransfer(httpRequest, new StationDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (StationDTO) httpResponse.getData();
        }
        return rs;
    }

    /**
     * 发放空间站的门票
     *
     * @param ticket
     * @return
     */
    public StationTicketDTO grantStationTicketToUser(StationTicketDTO ticket) throws Exception {
        Preconditions.checkNotNull(ticket, "票据信息不能为空");
        Preconditions.checkArgument(ticket.getToStationId() > 0, "空间信息不能为空");
        Preconditions.checkNotNull(ticket.getStartTime(), "票据需要设置开始时间");
        Preconditions.checkNotNull(ticket.getEndTime(), "票据需要设置结束时间");
        Preconditions.checkNotNull(ticket.getFromStationName(), "需要设置来源名称");
        Preconditions.checkNotNull(ticket.getUuid(), "被授权用户不能为空");
        Preconditions.checkNotNull(ticket.getName(), "票据名称不能为空");
        Preconditions.checkArgument(ticket.getTicketType() > 0, "票据类型需要设置");
        Preconditions.checkNotNull(ticket.getInfo(), "票据描述不能为空");
        StationTicketDTO rs = null;
        String request = this.buildGetRequestEndpoint(AdminUrlConfig.STATION_GRANT, null);
        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.POST, ticket);
        CrossResponse httpResponse = this.crossTransfer.postTransfer(httpRequest, new StationTicketDTOFormat());
        if (httpResponse != null && httpResponse.getData() != null) {
            rs = (StationTicketDTO) httpResponse.getData();
        }
        return rs;
    }


    /**
     * 发放道具给用户
     *
     * @param propertiesId
     * @param toUserId
     * @param num
     * @return
     */
    public StationPropertiesUserDTO grantPropertiesToUser(long propertiesId, String toUserId, int num) {
        Preconditions.checkArgument(propertiesId > 0, "道具ID不存在");
        Preconditions.checkNotNull(toUserId, "被发放道具用户不能为空");
        Preconditions.checkArgument(num > 0, "发放数量需要大于0");
//        Map<String, Object> parameter = Maps.newHashMap();
//        parameter.put("pid", propertiesId);
//        parameter.put("uuid", toUserId);
//        parameter.put("num", num);
//        String request = this.buildGetRequestEndpoint(AdminUrlConfig., parameter);
//        CrossRequest httpRequest = new CrossRequest(request, RequestMethod.GET);


        return null;
    }


    private String buildGetRequestEndpoint(String uri, Map<String, String> parameter) {
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append(this.config.getEndpoint());
        requestBuilder.append(uri);
        if (parameter != null && parameter.size() > 0) {
            requestBuilder.append("?");
            for (Map.Entry<String, String> para : parameter.entrySet()) {
                if (!Strings.isNullOrEmpty(para.getKey()) && para.getValue() != null) {
                    requestBuilder.append(para.getKey()).append("=").append(para.getValue().toString());
                    requestBuilder.append("&");
                }
            }
            return requestBuilder.toString().substring(0, requestBuilder.toString().length() - 1);
        }
        return requestBuilder.toString();
    }

}
