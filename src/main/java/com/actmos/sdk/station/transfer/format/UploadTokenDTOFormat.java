package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.UploadTokenDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;

import java.util.List;

public class UploadTokenDTOFormat extends ResponseFormat {
    public UploadTokenDTOFormat() {
    }

    public UploadTokenDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData != null) {
            if (isCollect) {
                List<UploadTokenDTO> data = JsonUtil.parseArray(srsData, UploadTokenDTO.class);
                rs = new CrossResponse(data);
            } else {
                UploadTokenDTO data = (UploadTokenDTO) JsonUtil.JsonObjectToObject(srsData, UploadTokenDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
