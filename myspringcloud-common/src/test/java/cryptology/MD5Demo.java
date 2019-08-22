package cryptology;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author 文通
 * @since 2019/8/15
 */
public class MD5Demo {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        // byte[] -> 摘要(byte[]) -> 16进制字符串
        System.out.println(Hex.encodeHexString(md5.digest("你好".getBytes())));
        System.out.println(Hex.encodeHexString(md5.digest("再见".getBytes())));
        System.out.println(Hex.encodeHexString(md5.digest("你好".getBytes())));
    }
}
