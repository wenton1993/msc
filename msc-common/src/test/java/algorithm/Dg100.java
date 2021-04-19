package algorithm;

/**
 * 递归计算从 1+2+...+100
 */
public class Dg100 {

    public static void main(String[] args) {
        System.out.println(compute(100));
    }

    // f(1) = 1, f(2) = 2 + f(1)...
    public static int compute(int i) {
        if (i == 1) {
            return 1;
        }

        return i + compute(i - 1);
    }

}
