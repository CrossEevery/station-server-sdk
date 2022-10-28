package com.actmos.sdk.station.config;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationConfig implements Serializable {
    private String endpoint;
    private String key;
    private String security;
}
