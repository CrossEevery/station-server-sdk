package com.actmos.sdk.station.dto;

public enum StationType {
    BUILD_ONESELF(1), BUILD_LIVE(2);

    private int type;

    public int getType() {
        return type;
    }

    StationType(int type) {
        this.type = type;
    }
}
