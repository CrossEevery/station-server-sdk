package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.token.HeaderTokenDTO;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.actmos.sdk.station.transfer.CrossTransfer;
import com.actmos.sdk.station.transfer.TransferSign;
import com.google.common.base.Preconditions;

import java.io.Serializable;
import java.util.List;

public class StationUserSDKClient implements Serializable {

    private StationConfig stationConfig;
    private CrossTransfer crossTransfer;

    public StationUserSDKClient(StationConfig stationConfig) {
        this.stationConfig = stationConfig;
        this.crossTransfer = new CrossTransfer(new TransferSign(stationConfig));
    }


    /**
     * 三方系统用户登录
     *
     * @param openId
     * @return
     */
    public HeaderTokenDTO authConnect(String openId) {
        Preconditions.checkNotNull(openId, "OpenUUID不能为空");

        return null;
    }

    /**
     * 创建一个空间站
     *
     * @param token
     * @param station
     * @return
     */
    public StationDTO creteStation(HeaderTokenDTO token, StationDTO station) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
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
     * 获取空间站基本信息
     *
     * @param token
     * @param stationId
     * @return
     */
    public StationDTO getDetail(HeaderTokenDTO token, long stationId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(stationId > 0, "空间站ID不存在");


        return null;
    }

    /**
     * 修改一个空间站
     *
     * @param token
     * @param station
     * @return
     */
    public StationDTO editStation(HeaderTokenDTO token, StationDTO station) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(station, "空间站信息不能为空");


        return null;
    }

    /**
     * 发布一个空间站
     *
     * @param token
     * @param stationId
     * @return
     */
    public StationDTO publishStation(HeaderTokenDTO token, long stationId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(stationId > 0, "空间站ID不存在");


        return null;
    }

    /**
     * 禁用用一个空间站
     *
     * @param token
     * @param stationId
     * @return
     */
    public boolean disableStation(HeaderTokenDTO token, long stationId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(stationId > 0, "空间站ID不存在");


        return false;
    }

    /**
     * 删除一个空间站
     *
     * @param token
     * @param stationId
     * @return
     */
    public boolean deleteStation(HeaderTokenDTO token, long stationId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(stationId > 0, "空间站ID不存在");


        return false;
    }

    /**
     * 获取针对该空间站已经配置了广告位信息
     *
     * @param token
     * @param stationId
     * @return
     */
    public List<StationSlotDTO> stationRoomSlotRead(HeaderTokenDTO token, long stationId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(stationId > 0, "空间站ID不存在");

        return null;
    }

    /**
     * 保存一个广告位信息
     *
     * @param token
     * @param slot
     * @return
     */
    public StationSlotDTO stationSlotSave(HeaderTokenDTO token, StationSlotDTO slot) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(slot, "广告位信息不能为空");
        Preconditions.checkNotNull(slot.getSlotCode(), "广告位编码不能为空");
        Preconditions.checkArgument(slot.getStationId() > 0, "空间站ID不存在");
        Preconditions.checkArgument(slot.getElementStationId() > 0, "素材ID不存在");

        return null;
    }

    /**
     * 获取文件夹下对应的素材列表
     *
     * @param token
     * @param folderId
     * @return
     */
    public List<StationElementDTO> listStationElement(HeaderTokenDTO token, long folderId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(folderId > 0, "素材文件夹不存在");

        return null;
    }

    /**
     * 为空间站上传一个素材
     *
     * @param token
     * @param element
     * @return
     */
    public StationElementDTO uploadStationElement(HeaderTokenDTO token, StationElementDTO element) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(element, "上传素材不能为空");
        Preconditions.checkNotNull(element.getName(), "名称不能为空");
        Preconditions.checkArgument(element.getElementType() > 0, "文件类型需要设定");
        Preconditions.checkArgument(element.getFolderId() > 0, "文件夹不能为空");


        return null;
    }

    /**
     * 删除一个素材
     *
     * @param token
     * @param elementId
     * @return
     */
    public StationElementDTO deleteStationElement(HeaderTokenDTO token, long elementId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(elementId > 0, "素材ID不存在");

        return null;
    }

    /**
     * 发放空间站的门票
     *
     * @param token
     * @param ticket
     * @return
     */
    public StationTicketDTO grantStationTicket(HeaderTokenDTO token, StationTicketDTO ticket) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(ticket, "票据信息不能为空");

        return null;
    }

    /**
     * 注册一个道具
     *
     * @param token
     * @param properties
     * @return
     */
    public StationPropertiesDTO registerProperties(HeaderTokenDTO token, StationPropertiesDTO properties) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(properties, "道具信息不能为空");

        return null;
    }

    /**
     * 启动一个道具
     *
     * @param token
     * @param propertiesId
     * @return
     */
    public StationPropertiesDTO enableProperties(HeaderTokenDTO token, long propertiesId) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(propertiesId > 0, "道具ID不存在");

        return null;
    }

    /**
     * 发放道具给用户
     *
     * @param token
     * @param propertiesId
     * @param toUserId
     * @param num
     * @return
     */
    public StationPropertiesUserDTO grantPropertiesToUser(HeaderTokenDTO token, long propertiesId, String toUserId, int num) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkArgument(propertiesId > 0, "道具ID不存在");
        Preconditions.checkNotNull(toUserId, "被发放道具用户不能为空");
        Preconditions.checkArgument(num > 0, "发放数量需要大于0");

        return null;
    }

    /**
     * 消费掉道具
     *
     * @param token
     * @param fromUserId
     * @param propertiesId
     * @param num
     * @return
     */
    public StationPropertiesUserDTO consumePropertiesToUsr(HeaderTokenDTO token, String fromUserId, long propertiesId, int num) {
        Preconditions.checkNotNull(token, "Token信息不能为空");
        Preconditions.checkNotNull(token.getToken(), "Token信息不能为空");
        Preconditions.checkNotNull(token.getOpenUUID(), "OpenUUID不能为空");
        Preconditions.checkNotNull(fromUserId, "消费用户的ID不能为空");
        Preconditions.checkArgument(propertiesId > 0, "道具ID不存在");
        Preconditions.checkArgument(num > 0, "消费数量需要大于0");

        return null;
    }
}
