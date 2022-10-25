package com.actmos.sdk.station.dto;

public enum StationAudioType {
    NO_AUDIO(-1),NORMAL(1),ALL(2),CONTROL(3);

    private int type;

    public int getType() {
        return type;
    }

    StationAudioType(int type) {
        this.type = type;
    }
}
