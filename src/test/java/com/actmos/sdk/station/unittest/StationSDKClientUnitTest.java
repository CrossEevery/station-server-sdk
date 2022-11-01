package com.actmos.sdk.station.unittest;

import com.actmos.sdk.station.StationUserSDKClient;
import com.actmos.sdk.station.config.StationConfig;
import com.actmos.sdk.station.dto.user.StationUserDTO;
import com.alibaba.fastjson.JSONObject;

public class StationSDKClientUnitTest {
    public static void main(String[] args) throws Exception {
        StationConfig stationConfig = new StationConfig();
        stationConfig.setEndpoint("https://api.open.crossevery.com");
        stationConfig.setKey("xxxx");
        stationConfig.setSecurity("xxxxxxxxx");
        StationUserSDKClient stationUserSDKClient = new StationUserSDKClient(stationConfig);
        StationUserDTO stationUserDTO = stationUserSDKClient.authConnect("xxxxxxxxxx");
        System.out.println(JSONObject.toJSONString(stationUserDTO));
    }
}
