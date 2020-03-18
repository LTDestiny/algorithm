package com.scarlett.op;

/**
 * @ClassName : BinarySearch
 * Description :
 * @Author : scarlett
 * @Date: 2020-03-18 21:28
 */
public class BinarySearch {

    /**
     * 二分法查找
     * @param arr 数组
     * @param key 查找的值
     * @return middle 为数组下标值(0,1,2...)
     */
    private static int search(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (key < arr[middle]) {
                end = middle - 1;
            } else if (key > arr[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
