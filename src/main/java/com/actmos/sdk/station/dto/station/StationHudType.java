package com.actmos.sdk.station.dto.station;

/**
 * -1 代表没有HUD
 * 1  代表常规模式
 * 2  代表剧本杀模式(直播平台)
 * 3  代表展厅模式
 * 4  代表游戏模式
 * 5  代表虚拟演唱会模式(直播平台)
 * 6  代表文旅模式
 */
public enum StationHudType {
    NO_HUD(-1), NORMAL(1), SES(2), SR(3), GR(4), LR(5), CT(6);

    private int type;

    public static StationHudType getHubType(int i) {
        StationHudType rs = StationHudType.NO_HUD;
        switch (i) {
            case 1:
                rs = StationHudType.NORMAL;
            case 2:
                rs = StationHudType.SES;
            case 3:
                rs = StationHudType.SR;
            case 4:
                rs = StationHudType.GR;
            case 5:
                rs = StationHudType.LR;
            case 6:
                rs = StationHudType.CT;
        }
        return rs;
    }

    public int getType() {
        return type;
    }

    StationHudType(int type) {
        this.type = type;
    }
}
