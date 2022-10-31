package com.actmos.sdk.station.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class JsonUtil implements Serializable {
    private static SerializeConfig mapping = new SerializeConfig();

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 最简单序列化为Json数据
     *
     * @param ojbObject
     * @return
     */
    public static String simpleJson(Object ojbObject) {
        return JSON.toJSONString(ojbObject, mapping, SerializerFeature.WriteMapNullValue);
    }

    /**
     * 转JAVA对象
     *
     * @param object
     * @param classZ
     * @return
     */
    public static Object JsonObjectToObject(JSONObject object, Class classZ) {
        return object.toJavaObject(classZ);
    }


    /**
     * 返序列化对象
     *
     * @param content
     * @return
     */
    public static Object StringToObject(String content, Class classZ) {
        return JSON.parseObject(content, classZ);
    }

    /**
     * 返序列化数组
     *
     * @param text
     * @param tClass
     * @param <T>
     * @return
     */
    public static final <T> List<T> parseArray(String text, Class<T> tClass) {
        return JSON.parseArray(text, tClass);
    }

    /**
     * 序列化数组
     * @param text
     * @param tClass
     * @return
     * @param <T>
     */
    public static final <T> List<T> parseArray(JSONObject text, Class<T> tClass) {
        return JSON.parseArray(JSON.toJSONString(text),tClass);
    }

    public static Object parser(String content, TypeReference typeReference) {
        return JSON.parseObject(content, typeReference);
    }
}
