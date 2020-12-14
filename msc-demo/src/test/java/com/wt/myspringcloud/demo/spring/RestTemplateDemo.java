package com.wt.myspringcloud.demo.spring;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wt.myspringcloud.common.util.JacksonUtils;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
import com.wt.myspringcloud.demo.pojo.req.PageDemoReq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 使用 RestTemplate 发送 GET 和 POST 请求
 *
 * @author 文通
 * @since 2020/8/29
 */
public class RestTemplateDemo extends BaseTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGet() {
        // 构建 URI
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:8771/demo/queryById?id={id}")
                .build(1);
        // 构建返回类型
        ParameterizedTypeReference<R<Demo>> getPtr = new ParameterizedTypeReference<R<Demo>>() {
        };
        // 发送GET请求
        ResponseEntity<R<Demo>> getResult = restTemplate.exchange(uri, HttpMethod.GET, null, getPtr);
        System.out.println(getResult);
    }

    @Test
    public void testPostByJson() throws JsonProcessingException {
        // 构建url
        String uri = "http://localhost:8771/demo/pageByJson";
        // 构建请求体
        PageDemoReq pageDemoReq = new PageDemoReq();
        pageDemoReq.setPage(new Page<>(2, 5));
        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 构建请求
        HttpEntity<String> httpEntity = new HttpEntity<>(JacksonUtils.writeValueAsString(pageDemoReq), headers);
        // 构建返回类型, 用 IPage 时会因为找不到默认的实现类而报错
        ParameterizedTypeReference<R<Page<Demo>>> postPtr = new ParameterizedTypeReference<R<Page<Demo>>>() {
        };
        // 发送POST请求
        ResponseEntity<R<Page<Demo>>> postResult = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, postPtr);
        System.out.println(postResult);
    }

}
