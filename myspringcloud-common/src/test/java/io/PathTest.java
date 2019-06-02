package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author 文通
 * @since 2019/5/18
 */
public class PathTest {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\wento\\Desktop\\bank\\localDirectory");
        try (final Stream<Path> list = Files.list(path)) {
           // list.forEach(e -> System.out.println(e.getFileName()));
            list.forEach(e -> {
                try {
                    Files.copy(e, Paths.get("D:\\wento\\Desktop\\bank\\test", e.getFileName().toString()));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }
        System.out.println("End");
    }

}
