package com.actmos.sdk.station.dto;

public enum StationDeliveryType {
    NO_DELIVERY(-1),NORMAL(1);

    private int type;

    public int getType() {
        return type;
    }

    StationDeliveryType(int type) {
        this.type = type;
    }
}
