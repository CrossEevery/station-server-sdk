package com.actmos.sdk.station.dto;

public enum StationKeyboardType {
    NO_KB(-1),NORMAL(1);

    private int type;

    public int getType() {
        return type;
    }

    StationKeyboardType(int type) {
        this.type = type;
    }
}
