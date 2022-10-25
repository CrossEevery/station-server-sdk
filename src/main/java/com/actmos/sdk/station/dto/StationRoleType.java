package com.actmos.sdk.station.dto;

public enum StationRoleType {
    NO_ROLE(-1), LIST(1), PACKAGE(2), CUSTOMIZE(3);

    private int type;

    public int getType() {
        return type;
    }

    StationRoleType(int type) {
        this.type = type;
    }
}
