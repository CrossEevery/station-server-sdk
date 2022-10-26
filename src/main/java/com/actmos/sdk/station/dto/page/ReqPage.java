package com.actmos.sdk.station.dto.page;

import lombok.Data;

import java.io.Serializable;

@Data
public  abstract  class ReqPage implements Serializable {
    private Integer pageSize=20;
    private Integer page=1;
}
