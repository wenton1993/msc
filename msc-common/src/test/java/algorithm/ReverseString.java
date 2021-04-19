package algorithm;

/**
 * 反转字符串
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        
        compute(s);
        
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

    public static void compute(char[] s) {
        // 循环，0-n/2
        // 交换
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

}
