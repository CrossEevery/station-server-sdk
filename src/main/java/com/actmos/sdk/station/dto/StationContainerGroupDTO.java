package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StationContainerGroupDTO implements Serializable {
    private long id;
    private String locationName;
    private String groupId;
    private String region;
    private String dsLocation;

  }
