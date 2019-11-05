package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author 文通
 * @since 2019/11/5
 */
public class GetChannel {

    private static final int BSIZE = 1024;
    private static final String fileDirectory = "C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\";

    public static void main(String[] args) throws IOException {
        // Write a file.
        FileChannel channel = new FileOutputStream(fileDirectory + "data.txt").getChannel();
        channel.write(ByteBuffer.wrap("Some text.".getBytes()));
        channel.close();
        // Add some to the end of the file.
        channel = new RandomAccessFile(fileDirectory + "data.txt", "rw").getChannel();
        channel.position(channel.size());
        channel.write(ByteBuffer.wrap("Some more.".getBytes()));
        channel.close();
    }
}
