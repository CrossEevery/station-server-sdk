package com.actmos.sdk.station.dto.message;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultDataDTO<T> implements Serializable {
    private int code;
    private String message;
    private T data;
}
