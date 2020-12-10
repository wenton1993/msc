package jvm;

/**
 * @author 文通
 * @since 2019/6/3
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String s = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s.intern() == s);// true

        String s2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(s.intern() == s2);// false

        String s3 = "计算机软件";
        System.out.println(s.intern() == s3);// true
        System.out.println(s == s3);// true
    }
}
