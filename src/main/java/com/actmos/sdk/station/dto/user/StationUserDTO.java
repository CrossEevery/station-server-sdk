package com.actmos.sdk.station.dto.user;

import com.actmos.sdk.station.dto.token.TokenInfoDTO;
import lombok.Data;

import java.io.Serializable;

@Data
public class StationUserDTO implements Serializable {
    private UserInfoDTO userInfo;
    private TokenInfoDTO tokenInfo;
}
