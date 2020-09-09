package com.example.test.algorithm.sorttest;

/**
 * 获取最大值 利用递归
 */
public class Test_11_GetMax {

    public static int getMax(int[] arr) {

        return max(arr, 0, arr.length-1);
    }

    public static int max(int[] arr, int l, int r) {

        if (l == r) {
            return arr[l];
        }
        int mid = (l + r) / 2;
        int leftMax = max(arr, l, mid);
        int rightMax = max(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3};
        System.out.println(getMax(arr));
    }
}
