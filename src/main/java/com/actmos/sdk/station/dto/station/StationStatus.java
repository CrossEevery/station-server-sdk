package com.actmos.sdk.station.dto.station;

public enum StationStatus {
    NO_CREATE(-1), PRE(0), NORMAL(1);

    private int type;

    public int getType() {
        return type;
    }

    StationStatus(int type) {
        this.type = type;
    }
}
