package com.actmos.sdk.station.dto.station;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 空间站素材信息
 */
@Data
public class StationElementDTO implements Serializable {
    private long id;
    private String code;
    private String name;
    private String fileName;
    private int elementType;
    private long stationId;
    private String path;
    private long folderId;
    private Date createTime;
    private Date updateTime;
    private int status;
    private String uuid;
}
