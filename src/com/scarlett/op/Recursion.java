package com.scarlett.op;

/**
 * @ClassName : Recursion
 * Description : 递归
 * @Author : scarlett
 * @Date: 2020-03-19 16:53
 */
public class Recursion {

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
        if (map[6][5] == 2) {   // 出口已找到
            return true;
        } else {
            if (map[i][j] == 0) {   // 如果当前这个点没有走过
                // 按照策略 下->右->上->左
                map[i][j] = 2;  // 假定该店是可以走通
                if (setWay(map, i + 1, j)) {    // 向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {    // 向右走
                    return true;
                } else if (setWay(map, i - 1, j)){  // 向上
                    return true;
                } else if (setWay(map, i, j - 1)) { // 向走
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
    }
}
