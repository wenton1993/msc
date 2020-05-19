package com.wt.mysrpingcloud.gateway.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.wt.myspringcloud.common.core.CommonResultCode;
import com.wt.myspringcloud.common.core.JsonResult;
import com.wt.myspringcloud.common.util.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 通用服务熔断处理器
 */
@Component
public class CommonFallbackProvider implements FallbackProvider {

    private final static Logger logger = LoggerFactory.getLogger(CommonFallbackProvider.class);

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        logger.error("您的请求已进入熔断处理！", cause);
        if (cause instanceof HystrixTimeoutException) {
            return this.response(HttpStatus.GATEWAY_TIMEOUT);
        } else {
            return this.response(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    private ClientHttpResponse response(final HttpStatus status) {
        return new ClientHttpResponse() {
            @Override
            public @NonNull
            HttpStatus getStatusCode() throws IOException {
                return status;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            @Override
            public @NonNull
            String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {
            }

            @Override
            public @NonNull
            InputStream getBody() throws IOException {
                JsonResult result = new JsonResult(false, CommonResultCode.SERVICE_DISABLED);
                return new ByteArrayInputStream(JacksonUtils.getMapper().writeValueAsString(result).getBytes(StandardCharsets.UTF_8));
            }

            @Override
            public @NonNull
            HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
