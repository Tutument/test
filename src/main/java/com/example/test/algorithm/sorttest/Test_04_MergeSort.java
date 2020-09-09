package com.example.test.algorithm.sorttest;

/**
 * 归并排序 分治思想
 */
public class Test_04_MergeSort {

    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr,0,arr.length-1);
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = 0;
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;

        while (p1 <= m && p2 <= r) {
            help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1<=m){
            help[i++] = arr[p1++];
        }
        while (p2<=r){
            help[i++] = arr[p2++];
        }
        for(int j = 0; j < help.length; j++){
            arr[l+j] = help[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3, 5};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
