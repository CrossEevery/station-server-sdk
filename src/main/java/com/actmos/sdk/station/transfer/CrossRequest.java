package com.actmos.sdk.station.transfer;

import lombok.Data;

import java.io.Serializable;


@Data
public class CrossRequest implements Serializable {
    private String uri;
    private RequestMethod method;
    private Object bodyData;

    public CrossRequest(String uri, RequestMethod method) {
        this.uri = uri;
        this.method = method;
    }

    public CrossRequest(String uri, RequestMethod method, Object bodyData) {
        this.uri = uri;
        this.method = method;
        this.bodyData = bodyData;
    }
}
