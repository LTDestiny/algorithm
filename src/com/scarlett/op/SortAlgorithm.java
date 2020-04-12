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
        // 标识变量，表示是否进行交换过
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            // 临时变量
            int temp = 0;
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 在一趟排序中，一次交换都没有发生
            if (!flag) {
                return;
            } else {
                // 重置，进行下次判断
                flag = false;
            }
        }
    }

    /**
     * 选择排序
     * @param arr 排序的数组
     */
    private static void selectSort(int[] arr) {
        int min = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 将找到的最小值交换
            if (minIndex != i) {
                arr[i] = min;
                arr[minIndex] = arr[i];
            }
        }
    }

    /**
     * 插入排序
     * @param arr 排序的数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 待插入的数
            int insertValue = arr[i];
            // arr[i]这个数前面一个的下标
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 31, 3, 45, 5, 6, 78, 23};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
