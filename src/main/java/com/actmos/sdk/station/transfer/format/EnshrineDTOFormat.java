package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.EnshrineDTO;
import com.actmos.sdk.station.dto.station.StationDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;

import java.util.List;

public class EnshrineDTOFormat extends ResponseFormat {
    public EnshrineDTOFormat() {
    }

    public EnshrineDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData!=null) {
            if (isCollect) {
                List<EnshrineDTO> data = JsonUtil.parseArray(srsData, EnshrineDTO.class);
                rs = new CrossResponse(data);
            } else {
                EnshrineDTO data = (EnshrineDTO) JsonUtil.JsonObjectToObject(srsData, EnshrineDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
