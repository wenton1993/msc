package io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 文通
 * @since 2019/5/18
 */
public class PathTest {

    public static void main(String[] args) {
        Path path = Paths.get("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\source.txt");
        System.out.println("result:" + Files.exists(path));
    }

}
