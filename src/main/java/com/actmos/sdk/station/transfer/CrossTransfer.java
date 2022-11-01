package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.common.HttpUtil;
import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.format.ResponseFormat;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

public class CrossTransfer implements Serializable {
    private HttpUtil httpUtil = HttpUtil.getInstance();

    private TransferSign transferSign;

    private boolean useSign = false;

    public CrossTransfer(TransferSign transferSign, boolean useSign) {
        this.transferSign = transferSign;
        this.useSign = useSign;
    }

    public CrossTransfer(TransferSign transferSign) {
        this.transferSign = transferSign;
    }

    public CrossResponse getTransfer(CrossRequest request, ResponseFormat format) throws IOException, StationException {
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(format);
        CrossResponse rs = null;
        String srs = null;
        if (useSign) {
            Map<String, String> header = this.createRequestHeader(request);
            srs = this.httpUtil.getGetResponseAsString(request.getUri(), header);
        } else {
            srs = this.httpUtil.getGetResponseAsString(request.getUri());
        }
        if (!Strings.isNullOrEmpty(srs)) {
            rs = format.formatResult(srs);
            if (rs != null) {
                rs.setRequest(request);
            }
        }
        return rs;
    }

    public CrossResponse postTransfer(CrossRequest request,ResponseFormat format) throws Exception {
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(format);
        Preconditions.checkNotNull(request.getBodyData());
        String postData = JsonUtil.simpleJson(request.getBodyData());
        CrossResponse rs = null;
        String srs = null;
        if (useSign) {
            Map<String, String> header = this.createRequestHeader(request);
            srs = this.httpUtil.getPostJsonRequest(request.getUri(), postData, header);
        } else {
            srs = this.httpUtil.getPostJsonRequest(request.getUri(), postData, null);
        }
        if (!Strings.isNullOrEmpty(srs)) {
            rs = format.formatResult(srs);
            if (rs != null) {
                rs.setRequest(request);
            }
        }
        return rs;
    }

    public Map<String, String> createRequestHeader(CrossRequest request) {
        String t = String.valueOf(System.currentTimeMillis());
        String sdkKey = this.transferSign.getSdkKey();
        Map<String, String> paras = request.getGetData();
        if (paras == null) {
            paras = Maps.newHashMap();
        }
        String sign = this.transferSign.getSign(paras, t);
        Map<String, String> headers = Maps.newHashMap();
        headers.put("station-sdk-key", sdkKey);
        headers.put("station-sdk-sign", sign);
        headers.put("station-sdk-time", t);
        return headers;
    }
}
