package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationAssemblyDTO implements Serializable {
    private long id;
    private int status;
    private int sex;
    private int type;
    private String code;
    private String photo;
}
