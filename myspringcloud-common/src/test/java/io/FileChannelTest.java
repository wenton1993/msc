package io;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileChannelTest {

    public static void main(String[] args) throws IOException {
        Path sourceFilePath = Paths.get("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\source.txt");
        FileChannel fileChannel = FileChannel.open(sourceFilePath);
        MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        char aChar;
        while (map.hasRemaining()) {
            aChar = map.getChar();
            System.out.println(aChar);
        }
        System.out.println("End");
    }
}
