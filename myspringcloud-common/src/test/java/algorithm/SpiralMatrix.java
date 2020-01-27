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
public class SpiralMatrix {

    public static void main(String[] args) {
        // generate(5);
        generate2(5);
    }

    /**
     * 我的方法
     * 特点：1.手动拐弯
     */
    private static void generate2(int n) {
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

        System.out.println("打印二维数组");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 别人的方法
    private static void generate(int n) {
        // 定义变量
        int num = 1;// 累加数
        int tar = n * n;// 最大值
        int l = 0, r = n - 1, t = 0, b = n - 1;// 边界值
        // 创建数组
        int[][] mat = new int[n][n];
        while (num <= tar) {
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }

        System.out.println("打印二维数组");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
