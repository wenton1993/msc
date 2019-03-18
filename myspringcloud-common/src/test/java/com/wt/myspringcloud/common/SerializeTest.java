package com.wt.myspringcloud.common;

import com.wt.myspringcloud.common.entity.User;
import org.junit.Test;

import java.io.*;

public class SerializeTest extends BaseTest {

    final String filePath = "E:\\Project\\Wt\\myspringcloud\\myspringcloud-common\\target\\text.txt";

    @Test
    public void test() throws IOException {
        FileOutputStream fs = new FileOutputStream(filePath);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        os.writeObject(new User(1L, "欧敏娜", 3));
        os.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fs = new FileInputStream(filePath);
        ObjectInputStream os = new ObjectInputStream(fs);
        User user = (User) os.readObject();
        os.close();
        System.out.println(user.toString());
    }

}
