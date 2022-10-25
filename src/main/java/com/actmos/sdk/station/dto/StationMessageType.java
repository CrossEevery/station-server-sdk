package com.actmos.sdk.station.dto;

public enum StationMessageType {
    NO_MESSAGE(-1),NORMAL(1);

    private int type;

    public int getType() {
        return type;
    }

    StationMessageType(int type) {
        this.type = type;
    }
}
