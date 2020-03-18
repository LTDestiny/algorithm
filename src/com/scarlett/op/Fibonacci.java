package com.scarlett.op;

/**
 * @ClassName : Fibonacci
 * Description :
 * @Author : scarlett
 * @Date: 2020-03-18 21:35
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(10));
    }

    public static int fib(int num) {
        // 判断：是否是第一个数和第二个数
        if (num == 1 || num == 2) {
            return 1;
        } else {
            // 循环调用本函数
            return fib(num - 2) + fib(num - 1);
        }
    }
}
