package com.sunchenchao.Lesson01;

import java.util.Arrays;

/**
 * 冒泡排序的实现
 * 时间复杂度为O(N^2)
 */
public class Code02_BubbleSort {
    public static void main(String[] args) {
        int arr[] = {1,9,6,18,5,1,18,20};
        bubbleSort(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);

    }
    public static void bubbleSort(int[] arr){
        for (int i =0 ;i<arr.length-1;i++){//需要N-1次
            for (int j = 0;j<arr.length-1-i;j++){//每一次都是可以免去一个参数排序 这个和冒泡没什么区别
                if (arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }

        }

    }
    public static void swap(int[] arr,int i ,int j){//交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
