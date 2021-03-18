package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字
 * 说明：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(compute(nums));
        System.out.println(compute2(nums));
    }

    /**
     * 遍历数组统计每个数字出现的次数
     */
    public static int compute(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            } else {
                hashMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v == 1) {
                return k;
            }
        }

        throw new IllegalArgumentException("No solution.");
    }

    /**
     * 遍历数组，逐个异或，相同的数字异或后等于 0
     */
    public static int compute2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum = sum ^ num;
        }

        return sum;
    }

}
