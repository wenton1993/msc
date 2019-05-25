package com.wt.myspringcloud.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * http 工具类
 * @author 文通
 */
public class HttpUtils {

    private final static CloseableHttpClient httpclient = HttpClients.createDefault();

    public static JSONObject sendGet(String uri, int timeout) throws IOException {
        HttpGet httpGet = new HttpGet(uri);
        RequestConfig requestConfig = RequestConfig.custom()
                // 连接超时时间
                .setConnectTimeout(timeout)
                // 响应超时时间
                .setSocketTimeout(timeout)
                .build();
        httpGet.setConfig(requestConfig);
        return execute(httpGet);
    }

    /**
     *
     * @param uri 请求路径
     * @param nvps 请求参数
     * @param timeout 自定义请求超时时间
     * @return JSONObject
     * @throws IOException
     */
    public static JSONObject sendPost(String uri, List<NameValuePair> nvps, int timeout) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        RequestConfig requestConfig = RequestConfig.custom()
                // 连接超时时间
                .setConnectTimeout(timeout)
                // 响应超时时间
                .setSocketTimeout(timeout)
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        return execute(httpPost);
    }

    public static JSONObject sendPostWithJson(String uri, Map<String, Object> params, int timeout) throws IOException {
        HttpPost httpPost = new HttpPost(uri);
        RequestConfig requestConfig = RequestConfig.custom()
                // 连接超时时间
                .setConnectTimeout(timeout)
                // 响应超时时间
                .setSocketTimeout(timeout)
                .build();
        httpPost.setConfig(requestConfig);
        httpPost.addHeader("Content-Type", "application/json");
        String paramsString = JSON.toJSONString(params);
        httpPost.setEntity(new StringEntity(paramsString));
        return execute(httpPost);
    }

    private static JSONObject execute(HttpUriRequest httpPost) throws IOException {
        try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return JSON.parseObject(responseString);
        }
    }

}
