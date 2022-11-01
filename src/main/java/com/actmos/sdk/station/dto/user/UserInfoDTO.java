package com.actmos.sdk.station.dto.user;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserInfoDTO implements Serializable {
    private String uuid;
    private String id;
    private String nickname;
    private String mobile;
    private String email;
    private String trade;
    private String qq;
    private String wx;
    private String zfb;
    private String avatar;
    private String introduction;
    private Date createTime;
    private String uname;
    private String thirdType;
    private String openid;
}
