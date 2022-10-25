package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationDeliveryDTO implements Serializable {
    private long id;
    private String uuid;
    private String code;
    private String ip;
    private int port;
    private String location;
    private int status;
    private long stationId;
    private String mapName;
    private int hudType;
    private String roomNo;
    private int audioType;
    private int deliveryType;
    private int propertiesType;
    private int userMode;
    private int suggestMode;
    private int keyboardType;
    private int messageType;
    private int ticketMode;
    private int abilityType;
    private long parentDeliveryId;
    private int olnop;
    private String deliveryName;


}
