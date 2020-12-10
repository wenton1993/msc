package clone;

import lombok.Data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * 深克隆
 * @author 文通
 * @since 2020/1/21
 */
@Data
public class DeepCloneDemo implements Serializable, Cloneable {

    private int age;
    private Integer id;
    private List<String> friends;

    @Override
    public Object clone() throws CloneNotSupportedException {
        DeepCloneDemo person = null;
        try {
            // 将对象写入到输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            // 将流反序列化成对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            person = (DeepCloneDemo) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void main(String[] args) {
        DeepCloneDemo person = new DeepCloneDemo();
        person.age = 1;
        person.id = 2;
        person.friends = Arrays.asList("Larry", "Moe", "Curly");
        DeepCloneDemo person2 = null;
        try {
            person2 = (DeepCloneDemo) person.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(person2.toString());
        System.out.println(person.age == person2.age);
        System.out.println(person.id == person2.id);
        System.out.println(person.friends == person2.friends);
    }
}
