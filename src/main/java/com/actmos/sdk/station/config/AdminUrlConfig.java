package com.actmos.sdk.station.config;

import java.io.Serializable;

public class AdminUrlConfig implements Serializable {
    public final static String UPLOAD_TOKEN = "/sdk/files/token";

    public final static String TEMPLATE_APPLY = "/sdk/template/apply";
    public final static String TEMPLATE_ENABLE = "/sdk/template/enable";
    public final static String TEMPLATE_DISABLE = "/sdk/template/disable";

    public final static String ENSHRINE_GRANT="/sdk/enshrine/grant";

    public final static String STATION_CREATE="/sdk/station/create";
    public final static String STATION_GRANT="/sdk/station/grant";

}
