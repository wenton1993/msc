package algorithm;

import java.util.Arrays;

/**
 * 归并排序
 *
 * 性能：
 * 平均时间复杂度：O(nlogn)
 *
 * 步骤：
 * 1.分解
 * 2.合并
 */
public class MergeSort {

    // 临时数组(可以把这个变量放到 mergeSort 方法中去，保证线程安全。放在外面可以让算法更清晰)
    private static int[] tempArray;

    public static void main(String[] args) {
        int[] nums = {3, 1, 7, 2, 6, 4};
        tempArray = new int[nums.length];
        mergeSort(nums, 0, nums.length / 2, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     *
     * 分析
     * 当 right - left = 0，不会进入进行归并排序
     * 当 right - left = 1，先递归到 mergeSort 时，right - left = 0，不会进行归并排；mergeSort 结束后再进入 sort 方法，对两个元素进行排序
     * 当 right - left = 2，先递归到 mergeSort 时，right - left = 1，再进一步递归到 mergeSort；mergeSort 结束后再进入 sort 方法，对两个元素进行排序，其中两两是已排序的
     * ...
     *
     * @param nums  待合并排序的数组
     * @param left  排序起始下标
     * @param mid   分隔下标
     * @param right 排序结束下标
     */
    private static void mergeSort(int[] nums, int left, int mid, int right) {
        if (left < right) {
            mergeSort(nums, left, (left + mid) / 2, mid);
            mergeSort(nums, mid + 1, (right + mid) / 2, right);
            sort(nums, left, mid, right);
        }
    }

    /**
     * 对数组中有序的两段进行合并排序
     *
     * @param nums  待合并排序的数组
     * @param left  排序起始下标
     * @param mid   分隔下标
     * @param right 排序结束下标
     */
    private static void sort(int[] nums, int left, int mid, int right) {
        int i = left, j = mid + 1, current = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                tempArray[current++] = nums[i++];
            } else {
                tempArray[current++] = nums[j++];
            }
        }

        while (i <= mid) {
            tempArray[current++] = nums[i++];
        }

        while (j <= right) {
            tempArray[current++] = nums[j++];
        }

        System.arraycopy(tempArray, left, nums, left, right - left + 1);
    }

}
