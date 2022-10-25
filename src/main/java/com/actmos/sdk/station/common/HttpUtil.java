package com.actmos.sdk.station.common;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * create by 2021/3/17
 * <p>
 * Desc: Http客户类
 *
 * @author wuhong@crossevery.com(jeff.wu)
 */
public class HttpUtil implements Serializable {

    private static final String TYPE_STRING = "string";

    private static final String TYPE_BYTEARRAY = "byte[]";

    private static final String TYPE_STREAM = "stream";

    private static HttpUtil instance;

    private HttpUtil() {
    }

    /**
     * 使用默认的页面请求编码：utf-8
     *
     * @return
     */
    public static HttpUtil getInstance() {
        return getInstance("UTF-8");
    }

    public static HttpUtil getInstance(String urlCharset) {
        if (instance == null) {
            instance = new HttpUtil();
        }
        //设置默认的url编码
        instance.setUrlCharset(urlCharset);
        return instance;
    }

    /**
     * 请求编码，默认使用utf-8
     */
    private String urlCharset = "UTF-8";

    /**
     * @param urlCharset 要设置的 urlCharset。
     */
    public void setUrlCharset(String urlCharset) {
        this.urlCharset = urlCharset;
    }

    /**
     * 获取字符串型返回结果，通过发起http post请求
     *
     * @param targetUrl
     * @param params
     * @return
     * @throws Exception
     */
    public String getResponseBodyAsString(String targetUrl, Map params) throws Exception {

        return (String) setPostRequest(targetUrl, params, TYPE_STRING, null);
    }

    /**
     * 获取字符数组型返回结果，通过发起http post请求
     *
     * @param targetUrl
     * @param params
     * @return
     * @throws Exception
     */
    public byte[] getResponseBodyAsByteArray(String targetUrl, Map params) throws Exception {

        return (byte[]) setPostRequest(targetUrl, params, TYPE_BYTEARRAY, null);
    }

    /**
     * 将response的返回流写到outputStream中，通过发起http post请求
     *
     * @param targetUrl    请求地址
     * @param params       请求参数<paramName,paramValue>
     * @param outputStream 输出流
     * @throws Exception
     */
    public void getResponseBodyAsStream(String targetUrl, Map params, OutputStream outputStream) throws Exception {
        if (outputStream == null) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }

        //response 的返回结果写到输出流
        setPostRequest(targetUrl, params, TYPE_STREAM, outputStream);
    }

    public String getPostRequest(String targetUrl, String postData) throws Exception {
        return (String) setPostRequest(targetUrl, postData, TYPE_STRING, null);
    }

    public String getPostJsonRequest(String targetUrl, String postData) throws Exception {
        return (String) setPostJsonRequest(targetUrl, postData, TYPE_STRING, null);
    }

    public String getPostRequest(String targetUrl, String postData, Map<String, String> header) throws Exception {
        return (String) setPostRequest(targetUrl, postData, TYPE_STRING, null, header);
    }

    /**
     * 根据请求获取请求返回的Header
     *
     * @param targetUrl
     * @param postData
     * @return
     * @throws Exception
     */
    public Map<String, String> getPostRequestHeader(String targetUrl, String postData) throws Exception {
        if (Strings.isNullOrEmpty(targetUrl)) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }
        Map<String, String> hds = Maps.newHashMap();
        Object res = null;
        HttpClient client = null;
        PostMethod method = null;
        RequestEntity re = new StringRequestEntity(postData, "text/html", "UTF-8");
        SimpleHttpConnectionManager shcm = null;
        try {
            shcm = new SimpleHttpConnectionManager(true);
            //连接超时,单位毫秒
            shcm.getParams().setConnectionTimeout(10000);
            //读取超时,单位毫秒
            shcm.getParams().setSoTimeout(60000);

            //设置获取内容编码
            shcm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, urlCharset);
            client = new HttpClient(new HttpClientParams(), shcm);
            method = new PostMethod(targetUrl);
            //设置请求参数的编码
            method.getParams().setContentCharset(urlCharset);

            //服务端完成返回后，主动关闭链接
            method.setRequestHeader("Connection", "close");
            method.setRequestHeader("Content-Type", "application/json");

            method.setRequestEntity(re);
            int sendStatus = client.executeMethod(method);

            if (sendStatus == 201) {
                Header[] headers = method.getResponseHeaders();
                if (headers != null) {
                    for (Header header : headers) {
                        if (header != null) {
                            hds.put(header.getName(), header.getValue());
                        }
                    }
                }

            } else {
                System.err.println("***************************");
                System.err.println("HttpUtil.setPostRequest()-请求url：" + targetUrl + " 出错\n请求参数有：" + postData + "！！！");
                System.err.println("***************************");
            }
        } catch (Exception e) {
            //释放链接
            if (method != null) {
                method.releaseConnection();
            }

            //关闭链接
            if (shcm != null) {
                shcm.shutdown();
            }
        }

        return hds;
    }

    /**
     * 发送请求
     *
     * @param targetUrl URL地址
     * @param postData  需要发送的数据
     * @return
     * @throws Exception
     */
    private Object setPostRequest(String targetUrl, String postData, String responseType, OutputStream outputStream, Map<String, String> header) throws Exception {
        if (Strings.isNullOrEmpty(targetUrl)) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }
        Object res = null;
        HttpClient client = null;
        PostMethod method = null;
        RequestEntity re = new StringRequestEntity(postData, "text/html", "UTF-8");
        SimpleHttpConnectionManager shcm = null;
        try {
            shcm = new SimpleHttpConnectionManager(true);
            //连接超时,单位毫秒
            shcm.getParams().setConnectionTimeout(10000);
            //读取超时,单位毫秒
            shcm.getParams().setSoTimeout(60000);

            //设置获取内容编码
            shcm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, urlCharset);
            client = new HttpClient(new HttpClientParams(), shcm);
            method = new PostMethod(targetUrl);
            //设置请求参数的编码
            method.getParams().setContentCharset(urlCharset);

            //服务端完成返回后，主动关闭链接
            method.setRequestHeader("Connection", "close");
            if (header != null) {
                for (Map.Entry<String, String> et : header.entrySet()) {
                    method.setRequestHeader(et.getKey(), et.getValue());
                }
            }
            method.setRequestEntity(re);
            int sendStatus = client.executeMethod(method);

            if (sendStatus == HttpStatus.SC_OK) {

                if (TYPE_STRING.equals(responseType)) {
                    res = method.getResponseBodyAsString();
                } else if (TYPE_BYTEARRAY.equals(responseType)) {
                    res = method.getResponseBody();
                } else if (TYPE_STREAM.equals(responseType)) {
                    InputStream tempStream = method.getResponseBodyAsStream();
                    byte[] temp = new byte[1024];
                    int index = -1;
                    while ((index = tempStream.read(temp)) != -1) {
                        outputStream.write(temp);
                    }
                }
            } else {
                System.err.println("***************************");
                System.err.println("HttpUtil.setPostRequest()-请求url：" + targetUrl + " 出错\n请求参数有：" + postData + "！！！");
                System.err.println("***************************");
            }
        } catch (Exception e) {
        } finally {
            //释放链接
            if (method != null) {
                method.releaseConnection();
            }

            //关闭链接
            if (shcm != null) {
                shcm.shutdown();
            }
        }
        return res;
    }

    /**
     * 发送请求
     *
     * @param targetUrl URL地址
     * @param postData  需要发送的数据
     * @return
     * @throws Exception
     */
    private Object setPostRequest(String targetUrl, String postData, String responseType, OutputStream outputStream) throws Exception {
        if (Strings.isNullOrEmpty(targetUrl)) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }
        Object res = null;
        HttpClient client = null;
        PostMethod method = null;
        RequestEntity re = new StringRequestEntity(postData, "text/html", "UTF-8");
        SimpleHttpConnectionManager shcm = null;
        try {
            shcm = new SimpleHttpConnectionManager(true);
            //连接超时,单位毫秒
            shcm.getParams().setConnectionTimeout(10000);
            //读取超时,单位毫秒
            shcm.getParams().setSoTimeout(60000);

            //设置获取内容编码
            shcm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, urlCharset);
            client = new HttpClient(new HttpClientParams(), shcm);
            method = new PostMethod(targetUrl);
            //设置请求参数的编码
            method.getParams().setContentCharset(urlCharset);

            //服务端完成返回后，主动关闭链接
            method.setRequestHeader("Connection", "close");

            method.setRequestEntity(re);
            int sendStatus = client.executeMethod(method);

            if (sendStatus == HttpStatus.SC_OK) {

                if (TYPE_STRING.equals(responseType)) {
                    res = method.getResponseBodyAsString();
                } else if (TYPE_BYTEARRAY.equals(responseType)) {
                    res = method.getResponseBody();
                } else if (TYPE_STREAM.equals(responseType)) {
                    InputStream tempStream = method.getResponseBodyAsStream();
                    byte[] temp = new byte[1024];
                    int index = -1;
                    while ((index = tempStream.read(temp)) != -1) {
                        outputStream.write(temp);
                    }
                }
            } else {
                System.err.println("***************************");
                System.err.println("HttpUtil.setPostRequest()-请求url：" + targetUrl + " 出错\n请求参数有：" + postData + "！！！");
                System.err.println("***************************");
            }
        } catch (Exception e) {
        } finally {
            //释放链接
            if (method != null) {
                method.releaseConnection();
            }

            //关闭链接
            if (shcm != null) {
                shcm.shutdown();
            }
        }
        return res;
    }

    /**
     * 发送请求
     *
     * @param targetUrl URL地址
     * @param postData  需要发送的数据
     * @return
     * @throws Exception
     */
    private Object setPostJsonRequest(String targetUrl, String postData, String responseType, OutputStream outputStream) throws Exception {
        if (Strings.isNullOrEmpty(targetUrl)) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }
        Object res = null;
        HttpClient client = null;
        PostMethod method = null;
        RequestEntity re = new StringRequestEntity(postData, "application/json", "UTF-8");
        SimpleHttpConnectionManager shcm = null;
        try {
            shcm = new SimpleHttpConnectionManager(true);
            //连接超时,单位毫秒
            shcm.getParams().setConnectionTimeout(10000);
            //读取超时,单位毫秒
            shcm.getParams().setSoTimeout(60000);

            //设置获取内容编码
            shcm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, urlCharset);
            client = new HttpClient(new HttpClientParams(), shcm);
            method = new PostMethod(targetUrl);
            //设置请求参数的编码
            method.getParams().setContentCharset(urlCharset);

            //服务端完成返回后，主动关闭链接
            method.setRequestHeader("Connection", "close");

            method.setRequestEntity(re);
            int sendStatus = client.executeMethod(method);

            if (sendStatus == HttpStatus.SC_OK) {

                if (TYPE_STRING.equals(responseType)) {
                    res = method.getResponseBodyAsString();
                } else if (TYPE_BYTEARRAY.equals(responseType)) {
                    res = method.getResponseBody();
                } else if (TYPE_STREAM.equals(responseType)) {
                    InputStream tempStream = method.getResponseBodyAsStream();
                    byte[] temp = new byte[1024];
                    int index = -1;
                    while ((index = tempStream.read(temp)) != -1) {
                        outputStream.write(temp);
                    }
                }
            } else {
                System.err.println("***************************");
                System.err.println("HttpUtil.setPostRequest()-请求url：" + targetUrl + " 出错\n请求参数有：" + postData + "！！！");
                System.err.println("***************************");
            }
        } catch (Exception e) {
        } finally {
            //释放链接
            if (method != null) {
                method.releaseConnection();
            }

            //关闭链接
            if (shcm != null) {
                shcm.shutdown();
            }
        }
        return res;
    }

    /**
     * 利用http client模拟发送http post请求
     *
     * @param targetUrl 请求地址
     * @param params    请求参数<paramName,paramValue>
     * @return Object                  返回的类型可能是：String 或者 byte[] 或者 outputStream
     * @throws Exception
     */
    private Object setPostRequest(String targetUrl, Map params, String responseType, OutputStream outputStream) throws Exception {
        if (Strings.isNullOrEmpty(targetUrl)) {
            throw new IllegalArgumentException("调用HttpClientUtil.setPostRequest方法，targetUrl不能为空!");
        }

        Object responseResult = null;
        HttpClient client = null;
        PostMethod post = null;
        NameValuePair[] nameValuePairArr = null;
        SimpleHttpConnectionManager connectionManager = null;
        try {
            connectionManager = new SimpleHttpConnectionManager(true);
            //连接超时,单位毫秒
            connectionManager.getParams().setConnectionTimeout(10000);
            //读取超时,单位毫秒
            connectionManager.getParams().setSoTimeout(60000);

            //设置获取内容编码
            connectionManager.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, urlCharset);
            client = new HttpClient(new HttpClientParams(), connectionManager);

            post = new PostMethod(targetUrl);
            //设置请求参数的编码
            post.getParams().setContentCharset(urlCharset);

            //服务端完成返回后，主动关闭链接
            post.setRequestHeader("Connection", "close");
            if (params != null) {
                nameValuePairArr = new NameValuePair[params.size()];

                Set key = params.keySet();
                Iterator keyIte = key.iterator();
                int index = 0;
                while (keyIte.hasNext()) {
                    Object paramName = keyIte.next();
                    Object paramValue = params.get(paramName);
                    if (paramName instanceof String && paramValue instanceof String) {
                        NameValuePair pair = new NameValuePair((String) paramName, (String) paramValue);
                        nameValuePairArr[index] = pair;
                        index++;
                    }
                }

                post.addParameters(nameValuePairArr);
            }

            int sendStatus = client.executeMethod(post);

            if (sendStatus == HttpStatus.SC_OK) {
                System.out.println("HttpUtil.setPostRequest()-responseType:" + responseType);

                if (TYPE_STRING.equals(responseType)) {
                    responseResult = post.getResponseBodyAsString();
                } else if (TYPE_BYTEARRAY.equals(responseType)) {
                    responseResult = post.getResponseBody();
                } else if (TYPE_STREAM.equals(responseType)) {
                    InputStream tempStream = post.getResponseBodyAsStream();
                    byte[] temp = new byte[1024];
                    int index = -1;
                    while ((index = tempStream.read(temp)) != -1) {
                        outputStream.write(temp);
                    }
                }
            } else {
                System.err.println("***************************");
                System.err.println("HttpUtil.setPostRequest()-请求url：" + targetUrl + " 出错\n请求参数有：" + JsonUtil.simpleJson(params) + "！！！");
                System.err.println("***************************");
            }
        } catch (Exception e) {

        } finally {
            //释放链接
            if (post != null) {
                post.releaseConnection();
            }

            //关闭链接
            if (connectionManager != null) {
                connectionManager.shutdown();
            }
        }

        return responseResult;
    }

    /**
     * 发起GET请求
     *
     * @param url
     * @return
     */
    public String getGetResponseAsString(String url) throws IOException {
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod(url);
        client.executeMethod(method);
        String res = method.getResponseBodyAsString();
        return res;
    }
}
