package com.actmos.sdk.station.dto.token;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeaderTokenDTO implements Serializable {
    private String token;
    private String openUUID;
    private String sdkKey;
}
