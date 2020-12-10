package algorithm;

import com.google.inject.internal.cglib.proxy.$MethodProxy;
import com.thoughtworks.xstream.io.binary.Token;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 文通
 * @since 2020/1/31
 */
public class MergeSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().mergeSort(new int[]{3, 1, 7, 2, 6, 4})));
    }

    public int[] mergeSort(int[] num) {
        int[] temp = new int[num.length];
        mergeSort(num, temp, 0, num.length - 1);
        return num;
    }

    private void mergeSort(int[] num, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(num, temp, left, mid);
            mergeSort(num, temp, mid + 1, right);
            sort(num, temp, left, mid, right);
        }
    }

    private void sort(int[] num, int[] temp, int left, int mid, int right) {
        int targetIndex = left;
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (num[l] < num[r]) {
                temp[targetIndex++] = num[l++];
            } else {
                temp[targetIndex++] = num[r++];
            }
        }
        while (l <= mid) {
            temp[targetIndex++] = num[l++];
        }
        while (r <= right) {
            temp[targetIndex++] = num[r++];
        }
        System.arraycopy(temp, left, num, left, right - left + 1);
    }
}
