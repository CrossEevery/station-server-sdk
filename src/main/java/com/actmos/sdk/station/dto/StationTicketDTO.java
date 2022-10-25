package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StationTicketDTO implements Serializable {
    private long id;
    private int status;
    private String uuid;
    private String code;
    private String name;
    private int ticketType;
    private Date startTime;
    private Date endTime;
    //如果为0则表示不限制来源或者没有来源
    private long fromStationId;
    private String fromStationName;
    private long toStationId;
    private String toStationName;
    private String info;
    private long toDeliveryId;
}
