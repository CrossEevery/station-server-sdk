package com.actmos.sdk.station.dto;

public enum StationTicketType {
    NO_CHECK(0), SINGLE(1), MULTIPASS(2), DELIVERY(3);

    private int type;

    public int getType() {
        return type;
    }

    StationTicketType(int type) {
        this.type = type;
    }
}
