package nestedclass;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 文通
 * @since 2019/5/21
 */
public class Runner {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StaticNestedClassExample obj = new StaticNestedClassExample();
        StaticNestedClassExample.Person person = new StaticNestedClassExample.Person();
        person.setName("煎蛋");
        person.setAge(1);
        StaticNestedClassExample.Person person2 = new StaticNestedClassExample.Person();
        person2.setName("大骚");
        person2.setAge(2);
        StaticNestedClassExample.Person person3 = new StaticNestedClassExample.Person();
        person3.setName("暗影猎手");
        person3.setAge(3);
        List<StaticNestedClassExample.Person> personList = new ArrayList<>();
        personList.add(person2);
        personList.add(person3);
        obj.setName("文通");
        obj.setPerson(person);
        obj.setFriends(personList);
        String jsonString = JSON.toJSONString(obj);
        System.out.println("ojb: " + jsonString);
        StaticNestedClassExample obj2 = JSON.parseObject(jsonString, StaticNestedClassExample.class);
        System.out.println("ojb2: " + obj2);

        // 序列化
        try (ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\object.txt"))) {
            objectInputStream.writeObject(obj);
        }
        // 反序列化
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\object.txt"))) {
            StaticNestedClassExample obj3 = (StaticNestedClassExample) objectInputStream.readObject();
            System.out.println("obj3: " + obj3);
        }
    }
}
