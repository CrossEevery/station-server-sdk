package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.StationDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;

public class StationDTOFormat extends ResponseFormat {

    public StationDTOFormat() {

    }

    public StationDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData!=null) {
            if (isCollect) {
                List<StationDTO> data = JsonUtil.parseArray(srsData, StationDTO.class);
                rs = new CrossResponse(data);
            } else {
                StationDTO data = (StationDTO) JsonUtil.JsonObjectToObject(srsData, StationDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
