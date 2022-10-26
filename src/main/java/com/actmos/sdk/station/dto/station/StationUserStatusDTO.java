package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationUserStatusDTO implements Serializable {
    private long time;
    private String uuid;
    private int event;
    private long stationId;
    private long deliveryId;

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        stb.append(time).append(",").append(uuid).append(",").append(event).append(",").append(stationId).append(",").append(deliveryId);
        return stb.toString();
    }
}
