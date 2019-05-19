package io;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author 文通
 * @since 2019/5/18
 */
public class OperateFilesTest {

    public static void main(String[] args) {
        Charset charset = Charset.forName("UTF-8");
        Path file = Paths.get("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\target.txt");

        // Writing a File by Using Buffered Stream I/O
        /*String s = "你好";
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(s, 0, s.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }*/

        // Creating and Writing a File by Using Stream I/O
        byte[] data = "英雄联盟".getBytes();
        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(file, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}
