package nestedclass;

import java.util.Iterator;

/**
 * inner class example
 *
 * @author 文通
 * @since 2019/5/21
 */
public class MyArrayStructure {

    // 数组的长度
    private final static int SIZE = 15;
    // 内部数组
    private int[] arrayOfInts = new int[SIZE];

    // 初始化数组
    public MyArrayStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printArrayWithFirstIterator() {
        MyArrayIterator iterator = this.new FirstIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void printArrayWithSecondIterator() {
        MyArrayIterator iterator = this.new SecondIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    // 嵌套接口（好像没有嵌套类这么多名堂）
    interface MyArrayIterator extends Iterator<Integer> {
    }

    private class FirstIterator implements MyArrayIterator {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        @Override
        public Integer next() {
            Integer retValue = arrayOfInts[nextIndex];
            nextIndex += 1;
            return retValue;
        }
    }

    public class SecondIterator implements MyArrayIterator {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        @Override
        public Integer next() {
            Integer retValue = arrayOfInts[nextIndex];
            nextIndex += 2;
            return retValue;
        }
    }
}
