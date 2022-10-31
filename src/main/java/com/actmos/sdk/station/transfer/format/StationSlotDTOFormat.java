package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.StationSlotDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;

public class StationSlotDTOFormat extends ResponseFormat{

    public StationSlotDTOFormat() {
    }

    public StationSlotDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData!=null) {
            if (isCollect) {
                List<StationSlotDTO> data = JsonUtil.parseArray(srsData, StationSlotDTO.class);
                rs = new CrossResponse(data);
            } else {
                StationSlotDTO data = (StationSlotDTO) JsonUtil.JsonObjectToObject(srsData, StationSlotDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
