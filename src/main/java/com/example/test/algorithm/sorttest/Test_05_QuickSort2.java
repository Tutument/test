package com.example.test.algorithm.sorttest;

import java.util.Stack;

public class Test_05_QuickSort2 {

    public static void sort(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        Stack<Integer> stack = new Stack<>();
        if (left < right) {
            stack.push(right);
            stack.push(left);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int[] index = partition(arr, l, r);
                if (l < index[0] - 1) {
                    stack.push(index[0] - 1);
                    stack.push(l);
                }
                if (r > index[1] + 1) {
                    stack.push(r);
                    stack.push(index[1] + 1);
                }
            }
        }

    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right ;
        //int cur = right;

        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, left++, ++less);
            } else if (arr[left] > arr[right]) {
                swap(arr, left, --more);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 6, 3, 5, 9, 7, 6};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
