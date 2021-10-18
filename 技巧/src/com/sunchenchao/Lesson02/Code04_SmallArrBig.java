package com.sunchenchao.Lesson02;

import java.util.Arrays;

/**
 * 将一个数据小的放到左边 大的放到右边
 */
public class Code04_SmallArrBig {
    public static void main(String[] args) {
        int [] arr = {1,89,9,45,4,5,6,9,4,53,1,2 };
        SmallArrBigProcess(arr,50);
        String s = Arrays.toString(arr);
        System.out.println(s);
    }
    public static void SmallArrBigProcess(int[] arr,int findNum){
        int start = 0;
        for (int i =0;i<arr.length;i++){
            if (arr[i]<=findNum){
                swap(arr,i,start++);
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
