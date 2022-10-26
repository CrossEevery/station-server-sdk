package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.page.SdkReqPage;
import com.actmos.sdk.station.dto.page.StdPagedList;
import com.actmos.sdk.station.dto.station.StationDTO;
import com.actmos.sdk.station.dto.station.StationPropertiesDTO;
import com.actmos.sdk.station.dto.station.StationPropertiesUserDTO;
import com.actmos.sdk.station.dto.station.StationTicketDTO;

import java.io.Serializable;

/**
 * Station Server SDK
 */
public class StationSDKClient implements Serializable {

    private StationConfig config;

    public StationSDKClient(StationConfig config) {
        this.config=config;
    }

    /**
     * 获取SDK KEY关联下的Station
     * @param page
     * @return
     */
    public StdPagedList<StationDTO> getStationsBy(SdkReqPage page){
        return null;
    }


    /**
     * 创建一个空间站
     * @param station
     * @return
     */
    public StationDTO creteStation(StationDTO station){
        return null;
    }

    /**
     * 获取空间站基本信息
     * @param stationId
     * @return
     */
    public StationDTO getDetail(long stationId){
        return null;
    }

    /**
     * 修改一个空间站
     * @param station
     * @return
     */
    public StationDTO editStation(StationDTO station){
        return null;
    }

    /**
     * 发布一个空间站
     * @param stationId
     * @return
     */
    public StationDTO publishStation(long stationId){
        return null;
    }

    /**
     * 禁用用一个空间站
     * @param stationId
     * @return
     */
    public boolean disableStation(long stationId){
        return false;
    }

    /**
     * 删除一个空间站
     *
     * @param stationId
     * @return
     */
    public boolean deleteStation(long stationId){
        return false;
    }

    /**
     * 发放空间站的门票
     * @param ticket
     * @return
     */
    public StationTicketDTO grantStationTicket(StationTicketDTO ticket){
        return null;
    }

    /**
     * 注册一个道具
     * @param properties
     * @return
     */
    public StationPropertiesDTO registerProperties(StationPropertiesDTO properties){
        return null;
    }

    /**
     * 启动一个道具
     * @param propertiesId
     * @return
     */
    public StationPropertiesDTO enableProperties(long propertiesId){
        return null;
    }

    /**
     * 发放道具给用户
     * @param propertiesId
     * @param toUserId
     * @param num
     * @return
     */
    public StationPropertiesUserDTO grantPropertiesToUser(long propertiesId,String toUserId,int num){
        return null;
    }

    /**
     * 消费掉道具
     * @param fromUserId
     * @param propertiesId
     * @param num
     * @return
     */
    public StationPropertiesUserDTO consumePropertiesToUsr(String fromUserId,long propertiesId,int num){
        return null;
    }
}
