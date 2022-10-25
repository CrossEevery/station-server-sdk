package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationOnlineServerDTO implements Serializable {
    private long id;
    private String uuid;
    private String code;
    private String ip;
    private int port;
    private String location;
    private int status;
    private long stationId;
}
