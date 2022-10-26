package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationFacebackDTO implements Serializable {
    private long id;
    private String uuid;
    private String code;
    private int status;
    private long stationId;
    private long deliveryId;
    private String content;
}
