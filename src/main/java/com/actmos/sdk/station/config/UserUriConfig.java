package com.actmos.sdk.station.config;

import java.io.Serializable;


public class UserUriConfig implements Serializable {
    public static final String STATION_PLAYER_CONFIG = "/stationpoint/player/config";
    public static final String STATION_PLAYER_CHECK = "/stationpoint/player/check";
    public static final String STATION_PLAYER_START = "/stationpoint/player/start";
    public static final String STATION_PLAYER_SLOT = "/stationpoint/player/slot";
    public static final String STATION_PLAYER_STOP = "/stationpoint/player/stop";
    public static final String STATION_PLAYER_DELIVERY = "/stationpoint/player/delivery";
    public static final String STATION_PLAYER_ONLINE = "/stationpoint/player/online";
    public static final String PLAYER_ROLE_PREFIX = "/stationpoint/role";
    public static final String PLAYER_ROLE_LIST = "/stationpoint/role/list";
    public static final String PLAYER_ROLE_PACKAGE = "/stationpoint/role/package";
    public static final String PLAYER_ROLE_BYUUID = "/stationpoint/role/self";
    public static final String PLAYER_ROLE_SAVE = "/stationpoint/role/save";
}
