package com.actmos.sdk.station.dto.station;

/**
 * 1 代表虚拟空间的常规权益
 * 2 代表数字藏品
 * 3 代表游戏道具
 * 4 代表地皮
 * 5 代表实体物品
 */
public enum StationPropertiesType {
    NO_PROPERTIES(-1), NORMAL(1), NFT(2), GAME_PROPS(3), GROUND(4), ENTITY(5);

    private int type;

    public int getType() {
        return type;
    }

    StationPropertiesType(int type) {
        this.type = type;
    }
}
