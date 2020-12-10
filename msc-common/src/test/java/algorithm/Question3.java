package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author 文通
 * @since 2019/7/15
 */
public class Question3 {

    public static void main(String[] args) {
        String s = "asdfasiensdifasslhia";
        System.out.println(new Question3().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<String> stringSet = new HashSet<>();
            int length = 0;
            for (int j = i; j < s.length(); j++) {
                String tempS = s.substring(j, j + 1);
                // 是否重复
                if (stringSet.contains(tempS)) {
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    break;
                }
                // 是否到达末尾
                if (j == s.length() -1) {
                    length ++;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    break;
                }
                // 未重复
                stringSet.add(tempS);
                length ++;
            }
        }
        return maxLength;
    }
}
