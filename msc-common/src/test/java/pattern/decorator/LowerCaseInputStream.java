package pattern.decorator;

import java.io.*;
import java.nio.charset.Charset;

/**
 * LowerCaseInputStream 是一个利用装饰者模式，将 FilterInputStream 包起来的类。功能是将读到的大写字符转换成小写字符。
 *
 * @author 文通
 * @since 2020/1/27
 */
public class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return c == -1 ? c : Character.toLowerCase(c);
    }

    public static void main(String[] args) {
        try (InputStream in = new LowerCaseInputStream(new ByteArrayInputStream("Hello World!".getBytes()))) {
            int c;
            while ((c = in.read()) >= 0) {
                /**
                 * 单个字节的转换不需要设置字符编码。
                 * 因为不管什么字符编码，都是用单字节来表示英文字符。
                 * 如果包含中文就不行了，那就需要用 Reader来处理了
                 */
                System.out.print(Character.toChars(c));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
