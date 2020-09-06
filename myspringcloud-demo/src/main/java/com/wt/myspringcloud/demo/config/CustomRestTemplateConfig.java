package com.wt.myspringcloud.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 自定义 RestTemplate 配置
 *
 * @author 文通
 * @since 2020/9/6
 */
@Configuration
public class CustomRestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // return new RestTemplate();// 默认的 RestTemplate
        return builder
                // ConnectTimeout 连接到服务端的超时时间
                // .setConnectTimeout(Duration.ofMillis(1000))
                // ReadTimeout 从服务端读取到可用资源的超时时间
                // .setReadTimeout(Duration.ofMillis(30 * 1000))
                .requestFactory(this::requestFactory)
                .build();
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory requestFactory() {
        // 创建连接池
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
        // 针对每个 Route(我的理解是 URL) 最大的连接数量, 默认 2
        connectionManager.setDefaultMaxPerRoute(10);
        // 最大连接数量, 默认 20
        connectionManager.setMaxTotal(100);

        // 构建 HttpClient, 用于执行请求
        CloseableHttpClient httpClient = HttpClients.custom()
                // 指定连接池
                .setConnectionManager(connectionManager)
                // 设置最大空闲时间
                .evictIdleConnections(30, TimeUnit.SECONDS)
                // 禁止重试
                .disableAutomaticRetries()
                // 默认的连接生存策略, 当响应头中有 Keep-Alive 的超时信息时就使用，没有就永远保持连接
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                // 自定义连接生存策略, 当响应头中有 Keep-Alive 的超时信息时就使用，没有就保持连接 30s
                .setKeepAliveStrategy(new CustomConnectionKeepAliveStrategy())
                .build();

        // 请求工厂, 用于创建 HttpRequest
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return requestFactory;
    }

    // 连接的生存策略配置类
    private static class CustomConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {

        private final long DEFAULT_SECONDS = 30;

        /**
         * 1. 尝试获取响应头中的 Keep-Alive 信息, 并找到其中的超时时间
         * 2. 找不到就返回默认的超时时间
         *
         * @param response 响应信息
         * @param context 连接状态
         * @return 保持连接的时间(毫秒)
         */
        @Override
        public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
            return Arrays.stream(response.getHeaders(HTTP.CONN_KEEP_ALIVE))
                    .filter(h -> StringUtils.equalsIgnoreCase(h.getName(), "timeout") && StringUtils.isNumeric(h.getValue()))
                    .findFirst()
                    .map(h -> NumberUtils.toLong(h.getValue(), DEFAULT_SECONDS))
                    .orElse(DEFAULT_SECONDS) * 1000;
        }

    }

}
