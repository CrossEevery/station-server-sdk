package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationConfigCharacterDTO implements Serializable {
    private boolean createSwitch = true;
    private boolean assemblySwitch = true;
    private String assemblyCdn;
    private String split;
    private String assemblyFileExt;
}
