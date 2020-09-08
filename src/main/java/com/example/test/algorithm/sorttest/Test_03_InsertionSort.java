package com.example.test.algorithm.sorttest;

public class Test_03_InsertionSort {

    public static void sort(int[] arr){
        if( arr == null || arr.length < 2){
            return;
        }

        for(int i = 1; i < arr.length ; i++){
            for(int j = i ; j > 0 && arr[j] < arr[j-1]; j--){
                swap(arr,j,j-1);
            }
        }

    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
