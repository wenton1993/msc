package io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) throws IOException {
        /*Path filePath = Paths.get("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\source.txt");
        try (Stream<String> lines = Files.lines(filePath)) {
            lines.forEach(System.out::println);
        }*/
        /*Optional<String> stringOptional = Optional.of("123");
        String s = stringOptional.orElseGet(Locale.getDefault()::getDisplayName);
        stringOptional.ifPresent(System.out::println);
        System.out.println(s);*/
    }

}
