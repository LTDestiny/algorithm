package com.scarlett.op;

import java.util.Arrays;

/**
 * @ClassName : SortAlgorithm
 * Description :
 * @Author : scarlett
 * @Date: 2020-03-23 20:29
 */
public class SortAlgorithm {

    /**
     * 冒泡排序
     * @param arr 排序的数组
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 临时变量
            int temp = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 31, 3, 45, 5, 6, 78, 23};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
