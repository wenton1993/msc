package algorithm;

/**
 * 寻找两个有序数组的中位数
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))
 *
 * @author 文通
 * @since 2020/1/30
 */
public class Test4 {

    public static void main(String[] args) {
        // System.out.println(new Test4().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(new Test4().findMedianSortedArrays2(new int[]{2, 2, 2, 2}, new int[]{2, 2, 2}));
    }

    // 存在数组为空的情况
    private double findIfExistNull(int[] nums1, int[] nums2) {
        // 先考虑其中一个数组为空的情况
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                // 数组长度为奇数
                return nums2[(nums2.length - 1) / 2];
            } else {
                // 数组长度为偶数
                return (nums2[(nums2.length - 2) / 2] + nums2[nums2.length / 2]) / 2.0;
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                // 数组长度为奇数
                return nums1[(nums1.length - 1) / 2];
            } else {
                // 数组长度为偶数
                return (nums1[(nums1.length - 2) / 2] + nums1[nums1.length / 2]) / 2.0;
            }
        }
        return -1;
    }

    /**
     * 思路：求排名第k的数字。假如 m+n=7，则找排名第4的元素；如果m+n=8，就找排名第4和第5的元素
     * 技巧：1.将总数组长度为基数或者偶数的情况当作一种情况来处理
     * 这个解答还没完成，还有问题
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        // 先考虑其中一个数组为空的情况
        if (nums1.length == 0) {
            if (nums2.length % 2 == 1) {
                // 数组长度为奇数
                return nums2[(nums2.length - 1) / 2];
            } else {
                // 数组长度为偶数
                return (nums2[(nums2.length - 2) / 2] + nums2[nums2.length / 2]) / 2.0;
            }
        }
        if (nums2.length == 0) {
            if (nums1.length % 2 == 1) {
                // 数组长度为奇数
                return nums1[(nums1.length - 1) / 2];
            } else {
                // 数组长度为偶数
                return (nums1[(nums1.length - 2) / 2] + nums1[nums1.length / 2]) / 2.0;
            }
        }
        // 两个数组都不为空的情况
        int length = nums1.length + nums2.length;// 总长度
        int c = 0, c2 = 0;// 标记num1和num2的位置
        // 要找排名第k的元素
        int k = 0;
        if (length % 2 == 0) {
            k = length / 2;
        } else {
            k = (length + 1) / 2;
        }
        // 循环排除，当k=1时停止排序
        while (k != 1) {
            int e = nums1[c + k / 2 - 1];// num1的比较对象
            int e2 = nums2[c2 + k / 2 - 1];// num2的比较对象
            if (e < e2) {
                c = c + k / 2;//排除num1中从c到c+k/2-1之间的元素
            } else {
                c2 = c2 + k / 2;//排除num2中从c2到c2+k/2-1之间的元素
            }
            k = k - k / 2;// k/2是被排除掉的，接下来要找新数组中第k-k/2个元素
        }
        // 找排序第一
        if (c < nums1.length && c2 < nums2.length) {
            if (nums1[c] < nums2[c2]) {
                if (length % 2 == 1) {
                    return nums1[c];
                } else {
                    if (c + 1 >= nums1.length || nums1[c + 1] > nums2[c2]) {
                        return (nums1[c] + nums2[c2]) / 2.0;
                    } else {
                        return (nums1[c] + nums1[c + 1]) / 2.0;
                    }
                }
            } else {
                if (length % 2 == 1) {
                    return nums2[c2];
                } else {
                    if (c2 + 1 >= nums2.length || nums2[c2 + 1] > nums1[c]) {
                        return (nums2[c2] + nums1[c]) / 2.0;
                    } else {
                        return (nums2[c2] + nums2[c2 + 1]) / 2.0;
                    }
                }
            }
        } else {
            if (c < nums1.length) {
                if (length % 2 == 1) {
                    return nums1[c];
                }
            }
        }
        return 0;
    }

    // 

    /**
     * 思路：1.合并数组并排序； 2.根据合并后的数组长度是奇书还是偶数，分情况找到中位数
     * 时间复杂度：O(m+n)
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 合并数组
        int length = nums1.length + nums2.length;
        int[] target = new int[length];
        int c = 0, c2 = 0, c3 = 0;
        while (c < nums1.length && c2 < nums2.length) {
            if (nums1[c] < nums2[c2]) {
                target[c3] = nums1[c];
                c++;
            } else {
                target[c3] = nums2[c2];
                c2++;
            }
            c3++;
        }
        for (; c < nums1.length; c++) {
            target[c3] = nums1[c];
            c3++;
        }
        for (; c2 < nums2.length; c2++) {
            target[c3] = nums2[c2];
            c3++;
        }
        // 查找
        if (length % 2 == 1) {
            return target[(length - 1) / 2];
        } else {
            return (target[(length - 2) / 2] + target[(length / 2)]) / 2.0;
        }
    }
}
