package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationConfigAudioDTO implements Serializable {
    private String roomNo;
    private String encrypt;
    private String appId;
}
