package com.actmos.sdk.station.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationContainerDTO implements Serializable {
    /**
     * 是否需要进行重试
     */
    private boolean isTry = false;

    /**
     * 可重试次数
     */
    private int tryTimes = 15;

    /**
     * 重试间隔时间 单位1000=1S
     */
    private int tryCoolTime = 4000;

    /**
     * 主播ID
     */
    private long stationId;

    /**
     * 调度的地区
     */
    private String location;


    private String uuid;

    /**
     * 云游戏的serverSession
     */
    private String serverSession;


    private String gameUUID;

    private String stopUUID;

    private String hostUUID;
}
