package spring;

import com.baomidou.mybatisplus.extension.api.R;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.wt.myspringcloud.common.pojo.req.UserReq;
import com.wt.myspringcloud.common.util.JacksonUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 文通
 * @since 2020/8/29
 */
public class RestTemplateDemo {

    public static void main(String[] args) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        // 构建url
        String urlForGet = "http://localhost:8771/mybatisDemo/queryById";
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        // 发送GET请求
        R<?> getResult = restTemplate.getForObject(urlForGet, R.class, params);
        System.out.println(getResult);

        // 构建url
        String urlForPost = "http://localhost:8771/user/queryUserById";
        // 构建请求体
        UserReq userReq = new UserReq();
        userReq.setId(1L);
        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 构建请求
        HttpEntity<String> httpEntity = new HttpEntity<>(JacksonUtils.writeValueAsString(userReq), headers);
        // 发送POST请求
        R<?> postResult = restTemplate.postForObject(urlForPost, httpEntity, R.class);
        System.out.println(postResult);
    }
}
