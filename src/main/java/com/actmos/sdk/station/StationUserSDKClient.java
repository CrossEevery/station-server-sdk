package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.token.HeaderTokenDTO;
import com.actmos.sdk.station.dto.user.StationUserDTO;

import java.io.Serializable;
import java.util.List;

public class StationUserSDKClient implements Serializable {

    private StationConfig stationConfig;


    public StationUserSDKClient(StationConfig stationConfig) {
        this.stationConfig = stationConfig;
    }


    /**
     * 三方系统用户登录
     * @param openId
     * @return
     */
    public HeaderTokenDTO authConnect(String openId){
        return null;
    }

    /**
     * 创建一个空间站
     * @param token
     * @param station
     * @return
     */
    public StationDTO creteStation(HeaderTokenDTO token,StationDTO station){
        return null;
    }

    /**
     * 获取空间站基本信息
     * @param token
     * @param stationId
     * @return
     */
    public StationDTO getDetail(HeaderTokenDTO token,long stationId){
        return null;
    }

    /**
     * 修改一个空间站
     * @param token
     * @param station
     * @return
     */
    public StationDTO editStation(HeaderTokenDTO token,StationDTO station){
        return null;
    }

    /**
     * 发布一个空间站
     * @param token
     * @param stationId
     * @return
     */
    public StationDTO publishStation(HeaderTokenDTO token,long stationId){
        return null;
    }

    /**
     * 禁用用一个空间站
     * @param token
     * @param stationId
     * @return
     */
    public boolean disableStation(HeaderTokenDTO token,long stationId){
        return false;
    }

    /**
     * 删除一个空间站
     *
     * @param token
     * @param stationId
     * @return
     */
    public boolean deleteStation(HeaderTokenDTO token,long stationId){
        return false;
    }

    /**
     * 获取针对该空间站已经配置了广告位信息
     *
     * @param token
     * @param stationId
     * @return
     */
    public List<StationSlotDTO> stationRoomSlotRead(HeaderTokenDTO token,long stationId){
        return null;
    }

    /**
     * 保存一个广告位信息
     *
     * @param token
     * @param slot
     * @return
     */
    public StationSlotDTO stationSlotSave(HeaderTokenDTO token,StationSlotDTO slot){
        return null;
    }

    /**
     * 获取文件夹下对应的素材列表
     *
     * @param token
     * @param folderId
     * @return
     */
    public List<StationElementDTO> listStationElement(HeaderTokenDTO token,long folderId){
        return null;
    }

    /**
     * 为空间站上传一个素材
     *
     * @param token
     * @param element
     * @return
     */
    public StationElementDTO uploadStationElement(HeaderTokenDTO token,StationElementDTO element){
        return null;
    }

    /**
     * 删除一个素材
     *
     * @param token
     * @param elementId
     * @return
     */
    public StationElementDTO deleteStationElement(HeaderTokenDTO token,long elementId){
        return null;
    }

    /**
     * 发放空间站的门票
     *
     * @param token
     * @param ticket
     * @return
     */
    public StationTicketDTO grantStationTicket(HeaderTokenDTO token,StationTicketDTO ticket){
        return null;
    }

    /**
     * 注册一个道具
     *
     * @param token
     * @param properties
     * @return
     */
    public StationPropertiesDTO registerProperties(HeaderTokenDTO token,StationPropertiesDTO properties){
        return null;
    }

    /**
     * 启动一个道具
     *
     * @param token
     * @param propertiesId
     * @return
     */
    public StationPropertiesDTO enableProperties(HeaderTokenDTO token,long propertiesId){
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
    public StationPropertiesUserDTO grantPropertiesToUser(HeaderTokenDTO token,long propertiesId,String toUserId,int num){
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
    public StationPropertiesUserDTO consumePropertiesToUsr(HeaderTokenDTO token,String fromUserId,long propertiesId,int num){
        return null;
    }
}
