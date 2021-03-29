package algorithm;

import java.util.Arrays;

/**
 * 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
 */
public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        compute(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void compute(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (k >= 0 && j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

}
