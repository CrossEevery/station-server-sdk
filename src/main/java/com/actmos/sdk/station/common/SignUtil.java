package com.actmos.sdk.station.common;

import com.google.common.base.Joiner;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;

public class SignUtil implements Serializable {

    private final static String KEY = "key";
    private final static String SIGN = "sign";

    /**
     * 参数转换
     *
     * @param parameter
     * @return
     */
    public TreeMap<String, String> getParameter(Map<String, String[]> parameter) {
        TreeMap<String, String> rs = null;
        if (parameter != null) {
            rs = new TreeMap<String, String>();
            for (Map.Entry<String, String[]> entry : parameter.entrySet()) {
                if (!SIGN.equals(entry.getKey().toLowerCase())) {
                    rs.put(entry.getKey(), Joiner.on(",").join(entry.getValue()));
                }
            }
        }
        return rs;
    }

    /**
     * 获取请求签名
     *
     * @param params
     * @return
     */
    public String getSign(TreeMap<String, String> params, String secret) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.append("secret_key=").append(secret);
        return DigestUtils.md5Hex(sb.toString().toLowerCase()).toLowerCase();
    }
}
