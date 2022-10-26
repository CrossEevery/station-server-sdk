package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.config.StationConfig;

import java.io.Serializable;

public class CrossTransfer implements Serializable {
    private StationConfig config;

    public CrossTransfer(StationConfig config) {
        this.config = config;
    }


}
