package com.actmos.sdk.station.dto.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginByThirdDTO implements Serializable {
    private String appKey;
    private String secretData;
}
