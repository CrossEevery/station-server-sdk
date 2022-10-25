package com.actmos.sdk.station.dto;

import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 空间站素材的文件夹
 */
@Data
public class StationFolderDTO implements Serializable {
    private long id;
    private String code;
    private String folderName;
    private int folderType;
    private long stationId;
    private Date createTime;
    private Date updateTime;
    private int status;
    private String uuid;
}
