package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationCharacterPackageDTO implements Serializable {
    private long id;
    private int status;
    private String code;
    private int assemblySex;
    private int assemblyType;
    private String photo;
}
