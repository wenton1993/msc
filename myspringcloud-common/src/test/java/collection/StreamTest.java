package collection;

import com.wt.myspringcloud.common.pojo.entity.User;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 文通
 * @since 2019/5/31
 */
public class StreamTest {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setId(Integer.valueOf(i).longValue());
            user.setName("user" + i);
            user.setAge(i);
            userList.add(user);
        }

        User user = new User();
        user.setId(4L);
        user.setName("user4");
        user.setAge(2);
        userList.add(user);

        Optional<User> max = userList.stream().max(Comparator.comparingInt(User::getAge));
        System.out.println("max: " + max.get());

        Optional<Integer> reduce = userList.stream().map(User::getAge).reduce(Integer::sum);
        System.out.println("reduce: " + reduce.get());

        Map<Integer, List<User>> collect = userList.stream().collect(Collectors.groupingBy(User::getAge));
        System.out.println("collect: " + collect);
    }
}
