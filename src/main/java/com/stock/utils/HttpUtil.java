package com.stock.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.util.ObjectUtils;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpUtil {

    private static final int TIMEOUT_SECONDS = 60;

    public static String get(String url) throws Exception {
        return get(url, null);
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 构建请求URL
            StringBuilder urlBuilder = new StringBuilder(url);
            if (!ObjectUtils.isEmpty(params)) {
                urlBuilder.append("?");
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                urlBuilder.deleteCharAt(urlBuilder.length() - 1); // 移除最后一个"&"
            }

            HttpGet httpGet = new HttpGet(urlBuilder.toString());

            // 设置请求超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(TIMEOUT_SECONDS * 1000)
                    .setConnectTimeout(TIMEOUT_SECONDS * 1000)
                    .build();
            httpGet.setConfig(requestConfig);

            // 执行请求
            HttpResponse response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        }
    }

    public static String post(String url, Map<String, String> params) throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {

            HttpPost httpPost = new HttpPost(url);

            if (!ObjectUtils.isEmpty(params)) {
                // 設定POST請求的參數
                List<NameValuePair> requestBody = new ArrayList<>();
                for (Map.Entry<String, String> param : params.entrySet()) {
                    String key = param.getKey();
                    String value = param.getValue();
                    requestBody.add(new BasicNameValuePair(key, value));
                }

                // 將參數設定到HttpPost的實體中
                httpPost.setEntity(new UrlEncodedFormEntity(requestBody));
            }

            // 设置请求超时时间
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout(TIMEOUT_SECONDS * 1000)
                    .setConnectTimeout(TIMEOUT_SECONDS * 1000)
                    .setConnectionRequestTimeout(TIMEOUT_SECONDS * 1000)
                    .build();
            httpPost.setConfig(requestConfig);

            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();

            return EntityUtils.toString(entity, StandardCharsets.UTF_8);
        }
    }
}
