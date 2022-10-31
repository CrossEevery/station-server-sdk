package com.actmos.sdk.station.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public class CrossResponse implements Serializable {
    private  CrossRequest request;
    protected Object data;
    public CrossResponse() {
    }

    public CrossResponse(Object data) {
        this.data = data;
    }
}
