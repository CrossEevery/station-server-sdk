package com.actmos.sdk.station.dto.station;

import com.tencent.cloud.Response;
import lombok.Data;

import java.io.Serializable;

@Data
public class UploadTokenDTO implements Serializable {
    private Response response;
    private String filePath;
    private String bucketName;
    private String region;
}
