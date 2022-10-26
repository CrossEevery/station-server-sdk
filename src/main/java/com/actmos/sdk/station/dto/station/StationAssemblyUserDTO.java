package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationAssemblyUserDTO implements Serializable {
    private long id;
    private int status;
    private String name;
    private String uuid;
    private int sex;
    private long hair;
    private String userPhoto;
    private String mesh;
    private long blouse;
    private long pants;
    private long shoe;
    private String code;
    private String photo;
}
