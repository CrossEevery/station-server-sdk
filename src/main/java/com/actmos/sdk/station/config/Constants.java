package com.actmos.sdk.station.config;

/**
 * @author jianbo@crossevery.com
 * @date 2021/9/14 16:05
 */
public class Constants {

    /**
     * DES_KEY
     */
    public static final String DES_KEY = "91754573fe83df46";

    public static final String DEFAULT_RETURN_FIELDS = "uuid|nickname|avatar|introduction|sex|province|city|birthday|checked_intro";

    /**
     * 状态，1生效，0失效
     */
    public static final Integer STATE_UP = 1;
    public static final Integer STATE_OFF = 0;


    //直播间状态 0未开始，1直播中，2暂停，3已结束
    public static final Integer LIVE_ROOM_STATE_WAIT = 0;
    public static final Integer LIVE_ROOM_STATE_START = 1;
    public static final Integer LIVE_ROOM_STATE_PAUSE = 2;
    public static final Integer LIVE_ROOM_STATE_STOP = 3;

    //主播玩家状态
    public static final Integer PLAYER_STATE_WAIT = 0;
    public static final Integer PLAYER_STATE_START = 1;
    public static final Integer PLAYER_STATE_OVER = 2;

    //主播设置直播状态，1开始推流，2暂停推流，3继续推流，4结束推流
    public static final Integer ANCHOR_PUSH_STATE_START = 1;
    public static final Integer ANCHOR_PUSH_STATE_PAUSE = 2;
    public static final Integer ANCHOR_PUSH_STATE_RESUME = 3;
    public static final Integer ANCHOR_PUSH_STATE_STOP = 4;

    //房间默认人数限制
    public static final Integer DEFAULT_LIVE_ROOM_LIMIT_PLAYER = 10;

    //默认主播的平魔宽高  iphone x
    public static final Integer DEFAULT_SCREEN_WIDTH = 886;
    public static final Integer DEFAULT_SCREEN_HEIGHT = 1920;


}
