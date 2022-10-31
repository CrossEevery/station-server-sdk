package com.actmos.sdk.station.transfer;

public enum RequestMethod {

    GET(1),POST(2);

    private int type;

    public int getType() {
        return type;
    }

    RequestMethod(int type) {
        this.type = type;
    }
}
