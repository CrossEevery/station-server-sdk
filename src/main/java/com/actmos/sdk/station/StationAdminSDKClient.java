package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.page.SdkReqPage;
import com.actmos.sdk.station.dto.page.StdPagedList;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.actmos.sdk.station.transfer.CrossTransfer;

import java.io.Serializable;
import java.util.List;

/**
 * Station Server SDK
 */
public class StationAdminSDKClient implements Serializable {

    private StationConfig config;
    private CrossTransfer crossTransfer;

    public StationAdminSDKClient(StationConfig config) {
        this.config=config;
        this.crossTransfer=new CrossTransfer(config);
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
     * @param page
     * @return
     */
    public StdPagedList<StationDTO> getStationsByPage(SdkReqPage page){
        return null;
    }


}
