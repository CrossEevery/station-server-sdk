package com.actmos.sdk.station.dto;

public enum StationUserModeType {
    SINGLE(1), ONLINE(2), ONLINE_ROOM(3);

    private int type;

    public int getType() {
        return type;
    }

    StationUserModeType(int type) {
        this.type = type;
    }
}
