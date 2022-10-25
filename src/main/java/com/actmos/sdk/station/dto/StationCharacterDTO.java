package com.actmos.sdk.station.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class StationCharacterDTO implements Serializable {
    private long id;
    private String nickName;
    private String info;
    private String smallPhoto;
    private String bigPhoto;
    private String iconPhoto;
    private String videoPath;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int status;
    private int sex;
    private int hair;
    private int blouse;
    private int pants;
    private int shoe;
}
