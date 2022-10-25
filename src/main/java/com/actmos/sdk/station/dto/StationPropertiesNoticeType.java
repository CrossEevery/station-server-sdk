package com.actmos.sdk.station.dto;

/**
 * ASYNC是异步模式
 * SYNC是同步模式
 */
public enum StationPropertiesNoticeType {
    NO_SYNC(0), ASYNC(1), SYNC(2);

    private int type;

    public int getType() {
        return type;
    }

    StationPropertiesNoticeType(int type) {
        this.type = type;
    }
}
