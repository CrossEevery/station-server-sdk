package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.common.SignUtil;
import com.actmos.sdk.station.config.StationConfig;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

public class TransferSign implements Serializable {
    private StationConfig config;

    public TransferSign(StationConfig config) {
        this.config = config;
    }

    public String getSdkKey() {
        return this.config.getKey();
    }

    public String getSign(Map<String, String> param,String t) {
        Map<String, String[]> params = getParams(param, t);
        return SignUtil.getSign(params, this.config.getSecurity());
    }

    private Map<String, String[]> getParams(Map<String, String> param, String t) {
        Map<String, String[]> params = Maps.newHashMap();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            params.put(entry.getKey(), new String[]{entry.getValue()});
        }
        params.put("sdk_t", new String[]{t});
        return params;
    }
}
