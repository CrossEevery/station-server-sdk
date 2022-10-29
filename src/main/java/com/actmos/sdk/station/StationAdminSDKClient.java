package com.actmos.sdk.station;

import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.page.SdkReqPage;
import com.actmos.sdk.station.dto.page.StdPagedList;
import com.actmos.sdk.station.dto.station.*;
import com.actmos.sdk.station.dto.token.HeaderTokenDTO;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.actmos.sdk.station.transfer.CrossTransfer;
import com.google.common.base.Preconditions;

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

}
