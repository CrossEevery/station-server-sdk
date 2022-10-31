package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.StationElementDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;

public class StationElementDTOFormat extends ResponseFormat {

    public StationElementDTOFormat() {

    }

    public StationElementDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData!=null) {
            if (isCollect) {
                List<StationElementDTO> data = JsonUtil.parseArray(srsData, StationElementDTO.class);
                rs = new CrossResponse(data);
            } else {
                StationElementDTO data = (StationElementDTO) JsonUtil.JsonObjectToObject(srsData, StationElementDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
