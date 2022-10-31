package com.actmos.sdk.station.dto.station;

import lombok.Data;

import java.util.Date;

@Data
public class EnshrineDTO {
    private int id;
    private Date createTime;
    private Date editTime;
    private long productId;
    private int productType;
    private String productTag;
    private String productName;
    private String productPhoto;
    private int status;
    private String tokenId;
    private long uid;
    private String uuid;
    private float currentPrice;
    private float dealPrice;
    private String sign;
    private String orderId;
    private int reversoStatus;
    private String enshrineCode;
    private int systemPresent;
    private long materialId;
    private String productDesc;
    private String appRange;
    private String payCenterAddress;
    private String assetsMid;
    private String materialCode;
    private String sdkKey;
}
