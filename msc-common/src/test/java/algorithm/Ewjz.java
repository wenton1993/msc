package algorithm;

/**
 * 二维矩阵
 */
public class Ewjz {

    public static void main(String[] args) {
        // int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        // int target = 20;

        int[][] matrix = {{-5}};
        int target = -5;

        System.out.println(compute(matrix, target));
    }

    /**
     * 二分法
     * <p>
     * 将该二维矩阵看成一个二叉树，左下角为根
     */
    public static boolean compute(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            int temp = matrix[i][j];
            if (temp == target) {
                printIndex(i, j);
                return true;
            } else if (temp < target) {
                j++;
            } else {
                i--;
            }
        }

        return false;
    }

    private static void printIndex(int i, int j) {
        System.out.println(i + "," + j);
    }

}
