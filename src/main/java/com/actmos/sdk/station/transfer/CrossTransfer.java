package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.common.HttpUtil;
import com.actmos.sdk.station.config.StationConfig;

import java.io.Serializable;

public class CrossTransfer implements Serializable {
   private  HttpUtil httpUtil=HttpUtil.getInstance();
   private TransferSign transferSign;

    public CrossTransfer(TransferSign transferSign) {
        this.transferSign = transferSign;
    }

}
