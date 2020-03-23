package com.scarlett.op;

/**
 * @ClassName : Recursion
 * Description : 递归
 * @Author : scarlett
 * @Date: 2020-03-19 16:53
 */
public class Recursion {

    /**
     * 定义一个max表示共有多少个皇后
     */
    int max = 8;
    /**
     * 定义一个数组arr，保存皇后存放位置的结果，比如arr[8] = {0, 4, 7, 5, 2, 6, 1, 3}
     */
    int[] array = new int[max];

    /**
     * 阶乘
     *
     * @param n 求n的阶乘
     * @return 返回阶乘的结果
     */
    private static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * 使用递归回溯来给小球找路
     * i,j坐标，从(1,1)开始出发
     * 如果小球到map[6][5]，则说明找到通路
     * 约定：当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通路可以走，3表示该点已经走过，但是走不通
     * 在走迷宫时，需要确定一个方式 下->右->上->左，如果该点走不通，再回溯
     *
     * @param map 表示地图
     * @param i   从哪个位置开始
     * @param j   从哪个位置开始
     * @return 如果找到通路，返回true，否则返回false
     */
    private static boolean setWay(int[][] map, int i, int j) {
        // 出口已找到
        if (map[6][5] == 2) {
            return true;
        } else {
            // 如果当前这个点没有走过
            if (map[i][j] == 0) {
                // 按照策略 下->右->上->左
                // 假定该点是可以走通
                map[i][j] = 2;
                // 向下走
                if (setWay(map, i + 1, j)) {
                    return true;
                    // 向右走
                } else if (setWay(map, i, j + 1)) {
                    return true;
                    // 向上
                } else if (setWay(map, i - 1, j)){
                    return true;
                    // 向左走
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    // 说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /**
     * 将皇后摆放的位置输出
     */
    private void print() {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    /**
     * 查看当我们防止第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 第个皇后
     * @return false 冲突
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i个皇后是否在同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 八皇后
     * 在8×8格的国际象棋上摆放八个皇后，使其不能互相攻击，
     * 即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法
     * 一共有92种解法
     * @param n 第n个皇后
     */
    private void queen8(int n) {
        // n = 8, 8个皇后已经放好
        if (n == max) {
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n，放到该行的第1列
            array[n] = i;
            // 判断当放置第n个皇后到第i列时，是否冲突
            if (judge(n)) {
                // 接着放n+1个皇后，开始递归
                queen8(n + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));

        System.out.println("测试迷宫");
        // 创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        // 1表示墙，上下全部置为1,初始化数组
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        // 在设置墙
        map[3][1] = 1;
        map[3][2] = 1;
        map[2][2] = 1;
        System.out.println("初始的输出地图");
        // 初始的输出地图
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        // 测试
        setWay(map, 1, 1);
        System.out.println("输出小球走过的地图");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        // 测试八皇后
        System.out.println("测试八皇后");
        Recursion recursion = new Recursion();
        recursion.queen8(0);
    }
}
