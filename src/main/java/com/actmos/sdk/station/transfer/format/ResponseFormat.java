package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.transfer.CrossResponse;

import java.io.Serializable;

public abstract class ResponseFormat implements Serializable {

    protected  boolean isCollect=false;

    public ResponseFormat() {
    }


    public ResponseFormat(boolean isCollect) {
        this.isCollect = isCollect;
    }

    public abstract CrossResponse formatResult(String srs);
}
