package com.example.test.algorithm.sorttest;

public class Test_12_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        int leftSum = mergeSort(arr, L, mid);
        int rightSum = mergeSort(arr, mid + 1, R);

        return leftSum + rightSum + merge(arr, L, mid, R);
    }

    public static int merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            res += arr[p1] < arr[p2] ? arr[p1] * (R - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3, 5};
        System.out.println(smallSum(arr));
//2+2+2+2+1*4+4+4+3
        int sum = 2+2+2+2+1*4+4+4+3;
        System.out.println(sum);
    }
}
