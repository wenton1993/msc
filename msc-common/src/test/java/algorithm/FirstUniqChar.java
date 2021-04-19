package algorithm;

import java.util.HashMap;

/**
 * 查找第一个唯一字符
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(compute(s));
    }

    public static int compute(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer count = map.get(s.charAt(i));
                count++;
                map.put(s.charAt(i), count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

}
