package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StationDeviceDTO implements Serializable {
    private long id;
    private String code;
    private String deviceName;
    private String devicePhoto;
    private String deviceDesc;
    private int deviceType;
    private long stationId;
    private String stationName;
    private String stationPhoto;
    private Date createTime;
    private Date updateTime;
    private int status;
}
