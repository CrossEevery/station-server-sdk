package com.actmos.sdk.station.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class StationFunctionButtonDTO implements Serializable {
    //屏幕模式 true表示横屏、false表示竖屏
    private boolean screen = true;
    //剧本按钮
    private boolean script = false;
    //节目单按钮
    private boolean playBill = false;
    //消息按钮
    private boolean message = false;
    //音频按钮
    private boolean audio = false;
    //键控区
    private boolean keyboard = false;
    //创建用户
    private boolean createUser=false;
    //背包按钮
    private boolean properties = false;
    //传递按钮
    private boolean delivery = false;
    //设置按钮
    private boolean setting = false;
    //用户信息
    private boolean user = false;
    //网络信息
    private boolean network = false;
    //重连按钮
    private boolean reconnect = false;
    //机位切换、拍照
    private boolean cameraStand = false;
    //付费按钮
    private boolean pay = false;
    //多人音频的用户信息
    private boolean userList = false;
    //返回按钮
    private boolean back=false;
    //反馈是否开启
    private boolean faceback=false;
}
