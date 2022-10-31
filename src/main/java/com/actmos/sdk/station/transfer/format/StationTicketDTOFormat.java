package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.StationTicketDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;

import java.util.List;

public class StationTicketDTOFormat extends ResponseFormat {

    public StationTicketDTOFormat() {
    }

    public StationTicketDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData != null) {
            if (isCollect) {
                List<StationTicketDTO> data = JsonUtil.parseArray(srsData, StationTicketDTO.class);
                rs = new CrossResponse(data);
            } else {
                StationTicketDTO data = (StationTicketDTO) JsonUtil.JsonObjectToObject(srsData, StationTicketDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
