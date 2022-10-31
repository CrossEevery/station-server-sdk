package com.actmos.sdk.station.unittest;

import com.actmos.sdk.station.StationUserSDKClient;
import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.alibaba.fastjson.JSONObject;

public class StationSDKClientUnitTest {
    public static void main(String[] args) throws Exception {
        StationConfig stationConfig = new StationConfig();
        stationConfig.setEndpoint("http://api.open.crossevery.com/");
        stationConfig.setKey("1234");
        stationConfig.setSecurity("91754573fe83df46");
        StationUserSDKClient stationUserSDKClient = new StationUserSDKClient(stationConfig);
        StationUserDTO stationUserDTO = stationUserSDKClient.authConnect("1234567890");
        System.out.println(JSONObject.toJSONString(stationUserDTO));
    }
}
