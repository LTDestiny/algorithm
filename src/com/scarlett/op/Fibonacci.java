package com.scarlett.op;

import java.util.HashMap;

/**
 * @ClassName : Fibonacci
 * Description :
 * @Author : scarlett
 * @Date: 2020-03-18 21:35
 */
public class Fibonacci {

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    static int count;

    public static void main(String[] args) {
        System.out.println(fib3(10));
        System.out.println(count);
    }

    /**
     * 递归 : 时间复杂度为O(2^n)。
     *
     * @param num num
     * @return n
     */
    public static int fib(int num) {
        // 判断：是否是第一个数和第二个数
        if (num == 1 || num == 2) {
            return 1;
        } else {
            // 循环调用本函数
            return fib(num - 2) + fib(num - 1);
        }
    }

    /**
     * 备忘录算法，自上而下，记住之前算过的值。减少方法的访问次数从而减少运行时间
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (hashMap.containsKey(n)) {
            return hashMap.get(n);
        } else {
            int value = fib2(n - 1) + fib2(n - 2);
            hashMap.put(n, value);
            return value;
        }
    }

    /**
     * 动态规划，自下向上的算法 : 时间复杂度为O(n)
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        count++;
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;

        }
        return temp;
    }
}
