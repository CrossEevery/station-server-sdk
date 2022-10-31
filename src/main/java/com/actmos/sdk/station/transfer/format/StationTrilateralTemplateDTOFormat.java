package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.dto.station.StationTrilateralTemplateDTO;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;

import java.util.List;

public class StationTrilateralTemplateDTOFormat extends ResponseFormat {
    public StationTrilateralTemplateDTOFormat() {
    }

    public StationTrilateralTemplateDTOFormat(boolean isCollect) {
        super(isCollect);
    }

    public CrossResponse formatResult(String srs) throws StationException {
        Preconditions.checkNotNull(srs);
        CrossResponse rs = null;
        JSONObject srsData = getSuccessString(srs);
        if (srsData != null) {
            if (isCollect) {
                List<StationTrilateralTemplateDTO> data = JsonUtil.parseArray(srsData, StationTrilateralTemplateDTO.class);
                rs = new CrossResponse(data);
            } else {
                StationTrilateralTemplateDTO data = (StationTrilateralTemplateDTO) JsonUtil.JsonObjectToObject(srsData, StationTrilateralTemplateDTO.class);
                rs = new CrossResponse(data);
            }
        }
        return rs;
    }
}
