package algorithm;

/**
 * 二维矩阵
 */
public class Ewjz {

    public static void main(String[] args) {
        // int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        // int target = 20;

        int[][] matrix = {{-1, 3}};
        int target = 3;

        System.out.println(compute(matrix, target));
    }

    public static boolean compute(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0, j = 0; i < m || j < n; i++, j++) {
            int t;
            if (i > m - 1) {
                t = matrix[m - 1][j];
            } else if (j > n - 1) {
                t = matrix[i][n - 1];
            } else {
                t = matrix[i][j];
            }

            if (target == t) {
                System.out.println(i + "," + j);
                return true;
            } else if (target > t) {
                continue;
            } else {
                for (int k = 0; k < j; k++) {
                    if (target == t) {
                        System.out.println(i + "," + k);
                        return true;
                    }
                }

                for (int k = 0; k < i; k++) {
                    if (target == t) {
                        System.out.println(k + "," + j);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
