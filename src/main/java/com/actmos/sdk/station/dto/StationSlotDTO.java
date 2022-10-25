package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 空间站广告位信息
 */
@Data
public class StationSlotDTO implements Serializable {
    private long id;
    private String uuid;
    private String code;
    private String slotCode;
    private long stationId;
    private long elementStationId;
    private long deliveryId;
    private String path;
    private int status;
}
