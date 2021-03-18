package algorithm;

/**
 * 多数元素
 * <p>
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 */
public class Dsys {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2, 3, 2};
        System.out.println(compute(nums));
    }

    /**
     * 摩尔投票法
     *
     * 1. 选择第一个元素为候选者
     * 2. 遍历数组，当元素等于候选者，计数+1，否则计数-1
     * 3. 当计数为 0 时，更换候选者
     */
    public static int compute(int[] nums) {
        int count = 0;
        int result = nums[0];
        for (int num : nums) {
            if (count == 0) {
                result = num;
            }

            if (num == result) {
                count++;
            } else {
                count--;
            }
        }

        if (count > 0) {
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
