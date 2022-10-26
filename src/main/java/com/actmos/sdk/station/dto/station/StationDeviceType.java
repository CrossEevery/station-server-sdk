package com.actmos.sdk.station.dto.station;

public enum StationDeviceType {
    NORMAL(1);

    private int type;

    public int getType() {
        return type;
    }

    StationDeviceType(int type) {
        this.type = type;
    }
}
