package com.actmos.sdk.station.dto.station;

public enum StationAvatarType {
    NO_AVATAR(-1),NORMAL(1),CUSTOM(2);

    private int type;

    public int getType() {
        return type;
    }

    StationAvatarType(int type) {
        this.type = type;
    }
}
