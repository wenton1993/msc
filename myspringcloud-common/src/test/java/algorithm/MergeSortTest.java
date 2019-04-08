package algorithm;

import java.util.Arrays;

/**
 * MergeSortTest 步骤: 1. 分解; 2. 合并.
 */
public class MergeSortTest {

    public static void main(String[] args) {
        int[] array = {3, 1, 7, 2, 6, 4};
        subArray = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    // 辅助数组
    private static int[] subArray;

    public static void mergeSort(int[] array, int start, int end) {
        // 递归的条件
        if (start < end) {
            // 选择一个中点, 将数组一分为二
            int mid = (start + end) / 2;
            // 对数组的前半部分进行排序
            mergeSort(array, start, mid);
            // 对数组的后半部分进行排序
            mergeSort(array, mid + 1, end);
            // 合并
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                subArray[k++] = array[i++];
            } else {
                subArray[k++] = array[j++];
            }
        }

        while (i <= mid) {
            subArray[k++] = array[i++];
        }
        while (j <= end) {
            subArray[k++] = array[j++];
        }

        System.arraycopy(subArray, 0, array, start, end - start + 1);
    }

}