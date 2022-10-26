package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationAbilityDTO implements Serializable {
    private long id;
    private String nickName;
    private String info;
    private int coolTime;
    private String iconPath;
    private String keyborad;
    private int suggest;
}
