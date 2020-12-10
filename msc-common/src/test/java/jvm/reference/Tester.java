package jvm.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author 文通
 * @since 2019/8/19
 */
public class Tester {

    public static void main(String[] args) {
        int[] ints = new int[] {1, 2, 3, 4};
        List<int[]> list = new ArrayList<>();
        list.add(ints);
        ints = null;
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(list.get(0)));
    }
}
