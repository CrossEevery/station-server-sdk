package com.actmos.sdk.station.transfer;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class CrossResponse implements Serializable {
    private  CrossRequest request;
    protected Object data;
}
