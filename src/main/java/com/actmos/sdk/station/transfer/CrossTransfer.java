package com.actmos.sdk.station.transfer;

import com.actmos.sdk.station.common.HttpUtil;
import com.actmos.sdk.station.common.JsonUtil;
import com.actmos.sdk.station.exception.StationException;
import com.actmos.sdk.station.transfer.format.ResponseFormat;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.io.IOException;
import java.io.Serializable;

public class CrossTransfer implements Serializable {
    private HttpUtil httpUtil = HttpUtil.getInstance();
    private TransferSign transferSign;

    public CrossTransfer(TransferSign transferSign) {
        this.transferSign = transferSign;
    }

    public CrossResponse getTransfer(CrossRequest request, ResponseFormat format) throws IOException, StationException {
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(format);
        CrossResponse rs=null;
        String srs=this.httpUtil.getGetResponseAsString(request.getUri());
        if(!Strings.isNullOrEmpty(srs)){
            rs=format.formatResult(srs);
            if(rs!=null){
                rs.setRequest(request);
            }
        }
        return rs;
    }

    public CrossResponse postTransfer(CrossRequest request,ResponseFormat format) throws Exception {
        Preconditions.checkNotNull(request);
        Preconditions.checkNotNull(format);
        Preconditions.checkNotNull(request.getBodyData());
        String postData= JsonUtil.simpleJson(request.getBodyData());
        CrossResponse rs=null;
        String srs=this.httpUtil.getPostJsonRequest(request.getUri(),postData);
        if(!Strings.isNullOrEmpty(srs)){
            rs=format.formatResult(srs);
            if(rs!=null){
                rs.setRequest(request);
            }
        }
        return rs;
    }
}
