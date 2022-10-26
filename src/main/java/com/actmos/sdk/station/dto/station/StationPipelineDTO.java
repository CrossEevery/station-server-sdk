package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationPipelineDTO implements Serializable {
    private long id;
    private String code;
    private String name;
    private int status;
    private int roomType;
    private int pipelineType;
    private long stationId;
    private String uuid;
    private String wss;
    private String qtt;
    private String messageQueueServer;
    private String messageQueueTopic;
    private String messageQueueGroup;
    private String pipelineKey;
    private String stationSecret;
    private String tokenSession;
}
