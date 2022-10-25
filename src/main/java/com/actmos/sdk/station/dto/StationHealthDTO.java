package com.actmos.sdk.station.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationHealthDTO implements Serializable {
    public long stationId;
    public long deliveryId;
    public long roomNum;
}
