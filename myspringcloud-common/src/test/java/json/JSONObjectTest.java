package json;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 文通
 * @since 2019/6/4
 */
public class JSONObjectTest {

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("Cust", "1");
        JSONObject jsonObject = new JSONObject(map);
        jsonObject.keySet();
        System.out.println(jsonObject.toString());
    }
}
