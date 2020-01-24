package clone;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * 浅克隆
 * @author 文通
 * @since 2020/1/21
 */
@Data
public class ShallowCopyDemo implements Cloneable {

    private int age;
    private Integer id;
    private List<String> friends;

    public static void main(String[] args) {
        ShallowCopyDemo person = new ShallowCopyDemo();
        person.age = 1;
        person.id = 2;
        person.friends = Arrays.asList("Larry", "Moe", "Curly");
        ShallowCopyDemo person2 = null;
        try {
             person2 = (ShallowCopyDemo) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person2.toString());
        System.out.println(person.age == person2.age);
        System.out.println(person.id == person2.id);
        System.out.println(person.friends == person2.friends);
    }
}
