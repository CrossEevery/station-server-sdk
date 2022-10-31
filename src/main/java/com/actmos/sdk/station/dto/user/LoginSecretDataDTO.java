package com.actmos.sdk.station.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 加密格式化数据
 */
@Data
public class LoginSecretDataDTO implements Serializable {
    private String openId;
}
