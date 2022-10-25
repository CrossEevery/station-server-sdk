package com.actmos.sdk.station.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间站
 */
@Data
public class StationNeighbourDTO implements Serializable {
    private long id;
    private String code;
    private String name;
    private long fromStationId;
    private long toStationId;
}
