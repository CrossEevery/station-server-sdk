package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.common.HttpUtil;

import java.io.Serializable;

public class CrossTransfer implements Serializable {
    private HttpUtil httpUtil = HttpUtil.getInstance();
    private TransferSign transferSign;

    public CrossTransfer(TransferSign transferSign) {
        this.transferSign = transferSign;
    }

    public CrossResponse getTransfer(CrossRequest request) {
        return null;
    }

    public CrossResponse postTransfer(CrossRequest request) {
        return null;
    }
}
