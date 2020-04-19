package com.wt.myspringcloud.common.base;

import com.wt.myspringcloud.common.pojo.entity.WtUser;
import org.junit.Test;

import java.io.*;

public class SerializeTest extends BaseTest {

    final String filePath = "E:\\Project\\Wt\\myspringcloud\\myspringcloud-common\\target\\text.txt";

    @Test
    public void test() throws IOException {
        FileOutputStream fs = new FileOutputStream(filePath);
        ObjectOutputStream os = new ObjectOutputStream(fs);
        // os.writeObject(new UserBuilder().setId(1L).setName("欧敏娜").setAge(3).createUser());
        os.close();
    }

    @Test
    public void test2() throws IOException, ClassNotFoundException {
        FileInputStream fs = new FileInputStream(filePath);
        ObjectInputStream os = new ObjectInputStream(fs);
        WtUser user = (WtUser) os.readObject();
        os.close();
        System.out.println(user.toString());
    }

}
