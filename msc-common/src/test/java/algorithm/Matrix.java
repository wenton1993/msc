package algorithm;

import java.util.Arrays;

/**
 * 螺旋矩阵
 * 输入: 3
 * 输出:
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 *
 * @author 文通
 * @since 2020/1/24
 */
public class Matrix {

    public static void main(String[] args) {
        compute(5);
        // compute2(5);
    }

    /**
     * 特点：
     *  1.定义了4个边界值，组合这四个边界值可以直接得到边界坐标
     */
    private static void compute(int n) {
        int max = n * n;
        int count = 1;
        int a = 0, b = 0, c = 0, d = 0;// 上下左右每条线路各跑了几次
        int[][] mat = new int[n][n];
        while (count <= max) {
            // 从左往右
            for (int i = d; i < n - b; i++) {
                mat[a][i] = count++;
                System.out.println(count);
            }
            a++;
            // 从上往下
            for (int i = a; i < n - c; i++) {
                mat[i][n - b - 1] = count++;
                System.out.println(count);
            }
            b++;
            // 从右往左
            for (int i = n - b - 1; i >= d; i--) {
                mat[n - c - 1][i] = count++;
                System.out.println(count);
            }
            c++;
            // 从下往上
            for (int i = n - c - 1; i >= a; i--) {
                mat[i][d] = count++;
                System.out.println(count);
            }
            d++;
        }

        printMatrix(mat);
    }

    /**
     * 我的方法
     *
     * 特点：
     *  1.手动拐弯
     *  2.相比方法 1，只定义了 2 个控制变量，分别用来表示下次横向和纵向移动的方向
     */
    private static void compute2(int n) {
        // 定义变量
        int num = 1;// 累加数
        int max = n * n;// 最大值，控制是否继续循环
        int l = n, h = n;// 长和高，控制下次拐弯后的移动次数
        int x = 0, y = 0;// 移动时的x和y轴坐标
        // 创建数组
        int[][] mat = new int[n][n];
        while (num <= max) {
            // 向左移动
            for (int i = 0; i < l; i++) {
                mat[x][y] = num++;// 填充数字到数组
                y++;// 更新坐标
            }
            h--;// 下次可移动的高度减1
            x++;y--;// 撤回向左多移动的一步，并且向下拐弯

            // 向下移动
            for (int i = 0; i < h; i++) {
                mat[x][y] = num++;
                x++;
            }
            l--;// 下次可移动的长度减1
            x--;y--;// 撤回向下多移动的一步，并且向右拐弯

            // 向右移动
            for (int i = 0; i < l; i++) {
                mat[x][y] = num++;
                y--;
            }
            h--;
            x--;y++;

            // 向上移动
            for (int i = 0; i < h; i++) {
                mat[x][y] = num++;
                x--;
            }
            l--;
            x++;y++;
        }

        printMatrix(mat);
    }

    /**
     * 打印二维数组
     */
    private static void printMatrix(int[][] mat) {
        System.out.println("打印二维数组");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
