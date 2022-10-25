package com.actmos.sdk.station.common;


import com.actmos.sdk.station.config.Constants;
import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 *
 * @author zhiguang@crossevery.com
 * @date 2018/5/4 14:19
 */
public class StringUtil {

    private static final char BRACKET_START = '{';
    private static final char BRACKET_END = '}';

    private StringUtil() {
    }

    public static String makeUuid() {
        return UUID.randomUUID().toString().toUpperCase().replace("-", "");
    }

    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    public static Integer getOrder(String shotName) {
        Integer result = 0;
        try {
            if (isInteger(shotName)) {
                result = Integer.parseInt(shotName);
            } else {
                result = Integer.valueOf(shotName);
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static String getFileName(String path) {
        String result = path;
        try {
            if (path.contains("?")) {
                path = path.substring(0, path.indexOf("?"));
            }
            result = path.substring(path.lastIndexOf("/") + 1);
        } catch (Exception e) {

        }
        return result;
    }

    public static String getShotName(String path) {
        String result = path;
        try {
            if (path.contains("?")) {
                path = path.substring(0, path.indexOf("?"));
            }
            String fileName = path.substring(path.lastIndexOf("/") + 1);
            result = fileName.substring(0, fileName.lastIndexOf("."));
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 格式化手机号码
     *
     * @param mobile
     * @return
     */
    public static String formatMobile(String mobile) {
        if (StringUtils.isBlank(mobile)) {
            return "";
        }

        char[] ch = mobile.toCharArray();
        for (int i = 3; i <= 6; i++) {
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }

    public static String decode(String s) {
        if (null == s) {
            return "";
        }
        try {
            return URLDecoder.decode(s.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 占位符替换
     * 如:StringUtil.format("{domain}:{port}", "http://www.baidu.com", 80)
     *
     * @param format
     * @param args
     * @return
     */
    public static String format(String format, Object... args) {
        StringBuilder sb = new StringBuilder();
        StringBuilder specifier = new StringBuilder();
        try {
            char[] ch = format.toCharArray();
            int num = 0;
            for (char c : ch) {
                if (c == BRACKET_START) {
                    specifier.append(c);
                    continue;
                }
                if (StringUtils.isNotBlank(specifier) && c != BRACKET_END) {
                    specifier.append(c);
                    continue;
                }
                if (c == BRACKET_END) {
                    specifier.append(c);
                    sb.append(args[num++]);
                    specifier = new StringBuilder();
                    continue;
                }
                sb.append(c);
            }

            // 没找到'}'
            if (StringUtils.isNotBlank(specifier)) {
                throw new IllegalArgumentException("can not find '}'");
            }

            return sb.toString();
        } catch (Exception ex) {
            throw new MissingFormatArgumentException(specifier.toString());
        }
    }


    /**
     * 高效MD5
     *
     * @param s
     * @return
     */
    public static String fastMd5(CharSequence s) {
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(s, Charsets.UTF_8);
        HashCode code = hasher.hash();
        return code.toString();
    }

    /**     * REDIS等长Key处理
     * 如: StringUtil.eqLength("00_101_{MD5(key1 + key2)}", "just", 1)
     *
     * @param format
     * @param args
     * @return
     */
    public static String eqLength(String format, Object... args) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : args) {
            sb.append(obj);
        }

        String md5 = fastMd5(sb);
        return format(format, md5);
    }


    /**
     * 链接添加schema
     *
     * @param url
     * @param schema
     * @return
     */
    public static String urlAddSchema(String url, String schema) {
        if (StringUtils.isBlank(schema)) {
            schema = "https";
        }
        if (StringUtils.isNotBlank(url) && url.startsWith("//")){
            url = schema + ":" + url;
        }
        return url;
    }

    /**
     * 链接添加https
     * @param url
     * @return
     */
    public static String urlAddHttps(String url) {
        return urlAddSchema(url, "https");
    }

    /**
     * 订单生产规则: 时间yyMMddHHmmss(8) + uuid后4位(4) + 随机数(4)
     *
     * @param uuid
     * @return
     */
    public static String getOrderId(String uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append(DateUtil.format(new Date(), DateUtil.SDF_YYMMDDHHMMSS));
        sb.append(uuid.substring(28).toUpperCase());
        sb.append((int) ((Math.random() * 9 + 1) * 1000));
        return sb.toString();
    }

    /**
     * 加密uuid
     *
     * @param uuid
     * @return
     */
    public static String encrytUuid(String uuid) {
        try {
            byte[] desKey = DESUtil.hexToBytes(Constants.DES_KEY);
            byte[] desResult = DESUtil.encrypt(uuid.getBytes(), desKey);
            return DESUtil.bytesToHex(desResult);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * 解密uuid
     *
     * @param uuid
     * @return
     */
    public static String decryptUuid(String uuid) {
        try {
            byte[] desKey = DESUtil.hexToBytes(Constants.DES_KEY);
            byte[] plain = DESUtil.decrypt(DESUtil.hexToBytes(uuid), desKey);
            return new String(plain);
        } catch (Exception ex) {
        }
        return null;
    }

    public static String encode(String s) {
        if (null == s) {
            return StringUtils.EMPTY;
        }

        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String[] splitString(String str) {
        List<String> list = new ArrayList<String>();
        if (StringUtils.isNotBlank(str)) {
            String[] strArray = StringUtils.split(str, ",");
            for(String s: strArray) {
                if (StringUtils.isNotBlank(s)) {
                    list.add(StringUtils.trim(s));
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static Integer[] splitInt(String str) {
        List<Integer> list = new ArrayList<Integer>();
        if (StringUtils.isNotBlank(str)) {
            String[] strArray = StringUtils.split(str, ",");
            for(String count: strArray) {
                if (StringUtils.isNotBlank(count) && StringUtils.isNumeric(count)) {
                    list.add(Integer.valueOf(count));
                }
            }
        }
        return list.toArray(new Integer[list.size()]);
    }

    /**
     * 创建url链接
     *
     * @param url
     * @param params
     * @return
     */
    public static String buildGetUrl(String url, HashMap<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (url != null && url.indexOf("?") != -1) {
            sb.append("&");
        } else {
            sb.append("?");
        }
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String getSeqId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    public static String[] split(String str, String s) {
        if (str == null)
            return null;

        if (s == null)
            return new String[] { str };

        StringTokenizer st = new StringTokenizer(str, s);
        String[] r = new String[st.countTokens()];
        int i = 0;
        while (st.hasMoreTokens())
            r[i++] = st.nextToken();
        return r;
    }

    public static Integer str2Integer(String value) {
        return str2Integer(value, null);
    }

    public static Integer str2Integer(String value, Integer defaultValue) {
        if (value != null) {
            try {
                value = value.trim();
                return Integer.valueOf(value);
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public static Long str2Long(String value) {
        return str2Long(value, null);
    }

    public static Long str2Long(String value, Long defaultValue) {
        if (value != null) {
            try {
                value = value.trim();
                return Long.valueOf(value);
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public static Float str2Float(String value) {
        return str2Float(value, null);
    }

    public static Float str2Float(String value, Float defaultValue) {
        if (value != null) {
            try {
                value = value.trim();
                return Float.valueOf(value);
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public static Double str2Double(String value) {
        return str2Double(value, null);
    }

    public static Double str2Double(String value, Double defaultValue) {
        if (value != null) {
            try {
                value = value.trim();
                return Double.valueOf(value);
            } catch (NumberFormatException ex) {
                return defaultValue;
            }
        }
        return defaultValue;
    }

    public static String[] str2Array(String value) {
        return str2Array(value, null);
    }

    public static String[] str2Array(String value, String[] defaultValue) {
        if (value != null && value.trim().length() > 0) {
            return split(value, ",");
        }
        return defaultValue;
    }

    public static List<String> str2List(String value) {
        return str2List(value, null);
    }

    public static List<String> str2List(String value, List<String> defaultValue) {
        if (value != null) {
            return Arrays.asList(split(value, ","));
        }
        return defaultValue;
    }


    public static String getRandomNumByLength(int length) {
        String base = "ABCDEFGHIJKMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < length; i++ ){
            int number = random.nextInt( base.length() );
            sb.append( base.charAt( number ) );
        }
        return sb.toString();
    }

    public static String getRandomNumByLength(Integer randomNumLength, String type){
        String rNum = DateUtil.format(new Date(), DateUtil.SDF_YYMMDDHHMMSS);
        Integer typeLength = type.length();
        int i = randomNumLength - rNum.length()-typeLength;
        String nonceStr = type+rNum+ getRandomNumByLength(i);
        return nonceStr;
    }

    public static String getExtString (String path) {
        String result = "jpg";
        try {
            String fileName = path.substring(path.lastIndexOf(".") + 1);
            if (fileName.contains("?")) {
                result = fileName.substring(0, fileName.indexOf("?"));
            } else {
                result = fileName;
            }
        } catch (Exception e) {

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.format("{domain}:{port}", "http://www.baidu.com", 80));
        System.out.println(getOrderId("ddc9525948e2472695242685bc5df973"));
        String key = encrytUuid("05772da32dce43e3a8a76917b880307e");
        System.out.println(key);
        System.out.println(decryptUuid(key));
    }
}
