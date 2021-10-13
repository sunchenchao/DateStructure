package com.sunchenchao.Lesson01;

import java.util.Arrays;

/**
 * 选择排序的实现
 * 等差数列 时间复杂度O(N^2)
 */
public class Code01_SelectionSort {

    public static void main(String[] args) {
        int arr[] = {1,9,6,18,5,1,18,20};
        selectionSort(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    public static void selectionSort(int[] arr){
        if (arr == null|| arr.length<=2 ){
            return;
        }
        for (int i=0;i<arr.length-1;i++ ){//循环0 -> (N-1)
            int max = i;
            for (int j=i;j<arr.length;j++){
                if (arr[max]>arr[j]){
                    max = j;
                }
            }
            if (max != i){
                swap(arr,i,max);
            }
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
