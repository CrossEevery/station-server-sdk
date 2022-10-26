package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 空间站基本信息
 */
@Data
public class StationDTO implements Serializable {
    private long id;
    private String roomNo;
    private String code;
    private String token;
    private String name;
    private Date createTime;
    private Date updateTime;
    private String uuid;
    private long publishId;
    private String publishName;
    private String tags;
    private String stationDesc;
    private String stationPhoto;
    private String stationPhoto2;
    private String stationPhoto3;
    private String stationPhoto4;
    private String stationPhoto5;
    private String stationGame;
    private int stationType = 1;
    private int hubType = 1;
    private int audioType = 1;
    private int deliveryType = 1;
    private int propertiesType = 1;
    private int keyboardType = 1;
    private int messageType;
    private int roleType = 1;
    private String stationKey;
    private String stationSecret;
    private int status;
    private int userMode = 0;
    private long enshrineId;
    private int suggestMode;
    private int avatarType;
    private int ticketMode;
    private int abilityType;
    private String sdkKey;
}
