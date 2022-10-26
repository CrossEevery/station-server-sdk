package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StationPropertiesDTO implements Serializable {
    private long id;
    private int stock;
    private String code;
    private String productName;
    private String productDesc;
    private String normal_photo;
    private String small_photo;
    private String big_photo;
    private int productType;
    private Date createTime;
    private Date updateTime;
    private int status;
    private long stationId;
    private String stationName;
    private String stationPhoto;
    private long deviceId;
    private String deviceName;
    private String devicePhoto;
    private int noticeMode;
    private String notice;
}
