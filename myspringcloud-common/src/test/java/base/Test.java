package base;

/**
 * @author 文通
 * @since 2019/7/2
 */
public class Test {

    public static void main(String[] args) {
        int a = Integer.valueOf("1010000111100001111000011110000", 2);// 二进制
        System.out.println(a);// 十进制
        // 左移 1 位
        System.out.println(a * 2);
        System.out.println(a << 1);
        System.out.println(Integer.valueOf("-1011110000111100001111000100000", 2));
        // 左移 2 位
        System.out.println(a << 2);
        System.out.println(Integer.valueOf("01000011110000111100001111000000", 2));

        System.out.println();

        int b = 9;
        System.out.println(Integer.toBinaryString(b));
        // 左移 1 位
        System.out.println(-b << 1);
        System.out.println(Integer.valueOf("-0000000000000000000000000010010", 2));
        // 左移 2 位
        System.out.println(-b << 2);
        System.out.println(Integer.valueOf("-0000000000000000000000000100100", 2));
        // 右移与除法
        System.out.println(-b >> 2);
        System.out.println(-b >>> 1);
        System.out.println(-b >>> 2);
        System.out.println(-b >>> 3);
        System.out.println(-b >>> 4);
        System.out.println(-b >>> 32);
        System.out.println(-b >>> 33);
    }
}
