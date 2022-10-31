package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class StationTrilateralTemplateDTO implements Serializable {
    private long id;
    private Date publishStartTime;
    private Date publishEndTime;
    private String tokenId;
    private String name;
    private String tag;
    private String info;
    private String photo128;
    private String photo320;
    private String photo512;
    private String photo1024;
    private String projectPath;
    private float price;
    private int stock;
    private int status;
    private long workroomId;
    private long workitemId;
    private int saleNum;
    private float saleMoney;
    private String appRange;
    private String code;
    private String deployCode;
    private String sdkKey;
}
