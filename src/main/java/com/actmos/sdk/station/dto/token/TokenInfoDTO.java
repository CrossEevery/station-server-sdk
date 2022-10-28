package com.actmos.sdk.station.dto.token;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenInfoDTO implements Serializable {
    private String ticket;
    private long expire;
}
