package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wt.myspringcloud.common.pojo.entity.WtUser;

import java.io.IOException;

/**
 * 学习如何使用Jackson
 *
 * @author 文通
 * @since 2020/5/17
 */
public class JacksonTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 序列化
        WtUser user = new WtUser();
        user.setId(9L);
        user.setAge(17);
        user.setName("敏娜");
        String userJsonString = objectMapper.writeValueAsString(user);
        System.out.println(user.toString());
        // 反序列化
        String userJsonString2 = "{\"name\":\"zcq\",\"id\":1}";
        WtUser wtUser = objectMapper.readValue(userJsonString2, WtUser.class);
        System.out.println("End");
    }
}
