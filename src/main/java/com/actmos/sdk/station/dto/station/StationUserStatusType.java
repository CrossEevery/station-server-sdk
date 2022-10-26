package com.actmos.sdk.station.dto.station;

public enum StationUserStatusType {

    START(1), HEALTH(2), GAME_IN(3), QUIT(99);

    private int type;

    public int getType() {
        return type;
    }

    StationUserStatusType(int type) {
        this.type = type;
    }
}
