package io;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * CopyBytes spends most of its time in a simple loop that reads the input stream and writes the output stream, one
 * byte at a time, as shown in the following figure.
 * @author 文通
 * @since 2019/5/17
 */
public class CopyBytes {

    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\source.txt");
             FileOutputStream out = new FileOutputStream("C:\\Users\\wento\\Project\\Wentong\\myspringcloud\\myspringcloud-common\\src\\test\\resources\\io\\target.txt")) {

            BufferedInputStream bufferedIn = new BufferedInputStream(in);
            BufferedOutputStream bufferedOut = new BufferedOutputStream(out);

            int c;
            // read() return the next byte of data, or -1 if the end of the file is reached.
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        }
    }

}
