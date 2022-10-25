package com.actmos.sdk.station.dto;

public enum StationFolderType {
    USER(2),SYSTEM(1);

    private int type;

    public int getType() {
        return type;
    }

    StationFolderType(int type) {
        this.type = type;
    }
}
