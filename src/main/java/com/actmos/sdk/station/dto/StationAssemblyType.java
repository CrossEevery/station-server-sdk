package com.actmos.sdk.station.dto;

public enum StationAssemblyType {
    HAIR(1), BLOUSE(2), PANTS(3), SHOE(4);

    private int type;

    public int getType() {
        return type;
    }

    StationAssemblyType(int type) {
        this.type = type;
    }
}
