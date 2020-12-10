package com.wt.myspringcloud.demo.controller;

import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.common.util.JacksonUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 模拟发送请求进行测试
 *
 * @author 文通
 * @since 2020/5/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockMvcExampleTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void before() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void exampleTest() throws Exception {
        System.out.println("==== 测试开始 ====");
        this.mockMvc.perform(get("/user/getUserById?id=3")).andExpect(status().isOk()).andDo(print()).andReturn();
    }

    /**
     * 发送 POST 请求，带 JSONString
     * @throws Exception 发送请求时发生异常
     */
    @Test
    public void testQuerySysUrlInfoList() throws Exception {
        WtUser user = new WtUser();
        user.setId(1L);
        RequestBuilder request = MockMvcRequestBuilders.post("/sys/urlInfoList")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(JacksonUtils.getMapper().writeValueAsString(user));
        MvcResult result = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print())
                .andReturn();
    }

}
