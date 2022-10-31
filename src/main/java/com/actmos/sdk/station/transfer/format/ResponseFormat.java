package com.actmos.sdk.station.transfer.format;

import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.CrossResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public abstract class ResponseFormat implements Serializable {

    protected  boolean isCollect=false;

    public ResponseFormat() {
    }


    public ResponseFormat(boolean isCollect) {
        this.isCollect = isCollect;
    }

    public abstract CrossResponse formatResult(String srs) throws StationException;


    protected JSONObject getSuccessString(String srs) throws StationException {
        JSONObject json = JSON.parseObject(srs);
        JSONObject srsData = null;
        if (json != null && json.containsKey("data") && json.containsKey("code") && json.getInteger("code") == 200) {
            srsData=json.getJSONObject("data");
        }else{
            throw new StationException("response message can't format");
        }
        return srsData;
    }
}
