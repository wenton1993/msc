package algorithm;

import java.util.Locale;

/**
 * 验证回文串
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
public class Hw {

    public static void main(String[] args) {
        // String target = "A man, a plan, a canal: Panama";
        // String target = "race a car";
        String target = "ab_a";

        System.out.println(compute(target));
    }

    public static boolean compute(String s) {
        s = s.replaceAll("\\W|_", "").toLowerCase();

        int i = 0, j = s.length() - 1;
        while (i < j) {
            // 获取 c1
            String c1 = s.substring(i, i + 1);
            i++;
            // 获取 c2
            String c2 = s.substring(j, j + 1);
            j--;
            // 比较 c1, c2
            if (!c1.equals(c2)) {
                return false;
            }
        }

        return true;
    }

}
