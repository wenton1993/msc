package algorithm;

import java.util.Arrays;

/**
 * 冒泡算法
 *
 * 技巧：
 * 1.在遍历过程较复杂的时候，使用闭区间更方便思考和计算
 */
public class Mp {

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 2, 6, 4};
        mp(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     *
     * 分析：
     * 第1次遍历，比较0和1、比较1和2，最后比较length-2和length-1；
     * 第2次遍历，比较0和1，比较1和2，最后比较length-3和length-2；
     * ...
     * 第j次遍历，比较0和1，最后比较length-1-j和length-1
     * 最后一次，比较0和1
     *
     * @param nums 待排序的数组
     */
    public static void mp(int[] nums) {
        // j 比较范围
        for (int j = nums.length - 1 - 1; j >= 0; j--) {
            // i 比较下标，length - 1 = 最大下标
            for (int i = 0; i <= j; i++) {
                // 将较大的值交换到后面
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

}
