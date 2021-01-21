package com.example.test.tomcat.timeout;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class RestTemplateUtil {

    private static final Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

   /* public static String sendPostJSON(JSONObject json, String url) {
        HttpMethod method = HttpMethod.POST;
        //发送http请求并返回结果
        return httpRestClient(url, method, json);
    }

    public static String sendGetJSON(JSONObject json, String url) {
        HttpMethod method = HttpMethod.GET;
        //发送http请求并返回结果
        return httpRestClient(url, method, json);
    }

    @SuppressWarnings(value = "deprecation")
    private static String httpRestClient(String url, HttpMethod method, JSONObject json) {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(1000 * 1000);
        requestFactory.setReadTimeout(100 * 1000);
        RestTemplate client = new RestTemplate(requestFactory);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8);
        HttpEntity<String> requestEntity = new HttpEntity<>(json.toString(), headers);
        //  执行HTTP请求
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }*/

    public static String sendPostJSON(JSONObject json ,String url ) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(100 * 1000)
                .setSocketTimeout(100 * 1000).setConnectTimeout(1000 * 1000).build();
        post.setConfig(requestConfig);
        String content = null;
        CloseableHttpResponse response = null;
        try {
            if (null != json) {
                // 构造一个form式表单实体
                StringEntity stringEntity = new StringEntity(json.toString(), ContentType.APPLICATION_JSON);
                // 将请求实体设置到httpPost对象中
                post.setEntity(stringEntity);
                response = httpClient.execute(post);
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            return content;
        } catch (IOException e) {
            logger.error("error", e);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("error", e);
                }
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("error", e);
            }
        }
        return null;
    }
}
