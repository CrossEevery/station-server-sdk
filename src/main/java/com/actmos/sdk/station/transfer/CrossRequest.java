package com.actmos.sdk.station.transfer;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;


@Data
public class CrossRequest implements Serializable {
    private String uri;
    private RequestMethod method;

    private Map<String,String> getData;
    private Object bodyData;

    public CrossRequest(String uri, RequestMethod method) {
        this.uri = uri;
        this.method = method;
    }

    public CrossRequest(String uri, RequestMethod method, Object bodyData) {
        this.uri = uri;
        this.method = method;
        if (method.getType() == RequestMethod.GET.getType()) {
            this.getData = (Map<String, String>) bodyData;
        } else if (method.getType() == RequestMethod.POST.getType()) {
            this.bodyData = bodyData;
        }
    }

}
