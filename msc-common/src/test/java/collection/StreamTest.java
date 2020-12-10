package collection;

import com.wt.myspringcloud.common.pojo.entity.WtUser;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 文通
 * @since 2019/5/31
 */
public class StreamTest {

    public static void main(String[] args) {
        List<WtUser> userList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            WtUser user = new WtUser();
            user.setId(Integer.valueOf(i).longValue());
            user.setName("demo" + i);
            user.setAge(i);
            userList.add(user);
        }

        WtUser user = new WtUser();
        user.setId(4L);
        user.setName("user4");
        user.setAge(2);
        userList.add(user);

        Optional<WtUser> max = userList.stream().max(Comparator.comparingInt(WtUser::getAge));
        System.out.println("max: " + max.get());

        Optional<Integer> reduce = userList.stream().map(WtUser::getAge).reduce(Integer::sum);
        System.out.println("reduce: " + reduce.get());

        Map<Integer, List<WtUser>> collect = userList.stream().collect(Collectors.groupingBy(WtUser::getAge));
        System.out.println("collect: " + collect);
    }
}
