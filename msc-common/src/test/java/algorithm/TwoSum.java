package algorithm;

import java.util.*;

/**
 * 两数之和
 *
 * @author 文通
 * @since 2019/7/4
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 13;

        // System.out.println(Arrays.toString(new TwoSum().twoSum2(nums, target)));
        System.out.println(Arrays.toString(new TwoSum().twoSum3(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // 两遍哈希表
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // 将所有元素放到 Map 中
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 遍历哈希表
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another) && map.get(another) != i) {
                return new int[]{i, map.get(another)};
            }
        }
        throw new IllegalArgumentException("No solution.");
    }

    // 一遍哈希表
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int another = target - nums[i];
            // 查找之前放入的元素
            if (map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            // 将元素和下标放入到一个新的 Map
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No solution.");
    }
}
