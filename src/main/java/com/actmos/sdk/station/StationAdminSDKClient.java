package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.page.SdkReqPage;
import com.actmos.sdk.station.dto.page.StdPagedList;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.actmos.sdk.station.transfer.CrossTransfer;
import com.actmos.sdk.station.transfer.TransferSign;
import com.google.common.base.Preconditions;

import java.io.Serializable;

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
        this.crossTransfer = new CrossTransfer(new TransferSign(config));
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
    public UploadTokenDTO applyUploadToken() {
        return null;
    }

    /**
     * 将上传的文件申请成为一个可发布的模板
     *
     * @param template
     * @return
     */
    public StationTrilateralTemplateDTO applyStationTrilateralTemplate(StationTrilateralTemplateDTO template) {


        return null;
    }

    /**
     * 将模板上架
     *
     * @param tid
     * @return
     */
    public StationTrilateralTemplateDTO enableStationTrilateralTemplate(long tid) {


        return null;
    }

    /**
     * 将模板下架
     *
     * @param tid
     * @return
     */
    public StationTrilateralTemplateDTO disableStationTrilateralTemplate(long tid) {


        return null;
    }

    /**
     * 将模板授权给一个用户
     *
     * @param tid
     * @param openUUID
     * @return
     */
    public EnshrineDTO grantTemplateToUser(long tid, String openUUID) {


        return null;
    }

    /**
     * 使用模板创建一个空间站
     * @param station
     * @return
     */
    public StationDTO createStation(StationDTO station){
        Preconditions.checkNotNull(station, "空间信息不能为空");
        Preconditions.checkNotNull(station.getName(), "空间站名称不对为空");
        Preconditions.checkArgument(station.getPublishId() > 0, "发布者的ID不存在");
        Preconditions.checkNotNull(station.getStationDesc(), "空间站的描述不能为空");
        Preconditions.checkNotNull(station.getTags(), "空间站的标签不能为空");
        Preconditions.checkNotNull(station.getStationPhoto(), "空间站的1号图片不能为空");
        Preconditions.checkArgument(station.getHubType() > 0, "请选择空间站的HUD");
        Preconditions.checkArgument(station.getAudioType() > 0, "请选择空间站的音频模式");
        Preconditions.checkArgument(station.getDeliveryType() > 0, "请选择空间站的传送模式");
        Preconditions.checkArgument(station.getPropertiesType() > 0, "请选择空间站的道具模式");
        Preconditions.checkArgument(station.getUserMode() > 0, "请选择空间站的用户模式");
        Preconditions.checkArgument(station.getEnshrineId() > 0, "空间站模板ID不能为空");


        return null;
    }

    /**
     * 发放空间站的门票
     *
     * @param ticket
     * @return
     */
    public StationTicketDTO grantStationTicketToUser(StationTicketDTO ticket) {
        Preconditions.checkNotNull(ticket, "票据信息不能为空");

        return null;
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



        return null;
    }

}
