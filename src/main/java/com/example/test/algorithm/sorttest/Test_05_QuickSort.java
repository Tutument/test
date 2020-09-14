package com.example.test.algorithm.sorttest;

public class Test_05_QuickSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int l, int r) {

        if (l < r) {
            int[] partition = partition(arr, l, r);
            quickSort(arr, l, partition[0] - 1);
            quickSort(arr, partition[1] + 1, r);
        }
    }

    public static int[] partition(int[] arr, int l, int r) {

        int less = l - 1;
        int more = r + 1;
        int cur = r;
        while (l < more) {
            if (arr[l] < arr[cur]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[cur]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3, 5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
