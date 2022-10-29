package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.config.StationConfig;

import java.io.Serializable;

public class TransferSign implements Serializable {
    private StationConfig config;

    public TransferSign(StationConfig config) {
        this.config = config;
    }
}
