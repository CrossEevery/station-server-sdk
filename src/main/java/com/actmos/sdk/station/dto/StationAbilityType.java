package com.actmos.sdk.station.dto;

public enum StationAbilityType {
    NO_ABILITY(-1), NORMAL_ABILITY(1);

    private int type;

    public int getType() {
        return type;
    }

    StationAbilityType(int type) {
        this.type = type;
    }
}
