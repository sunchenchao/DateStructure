package com.sunchenchao.Lesson01;

import java.util.Arrays;

public class Code04_insertionSort {
    public static void main(String[] args) {
        int[] arr = {1,8,5,2,3,7,456,9};
        insertionSort(arr);
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    public static void insertionSort(int[] arr){
        // 看1-2位置  第二个位置往前比对 如果比第二个数字大就是交换
        // 看1-3位置  第三个位置往前比对  然后第二个位置往前比对  如果数字大就交换
        // 同理
        //0-1 0-2
        for (int i =1 ;i<arr.length;i++){
            for (int j=i;j>0;j--){
                if (arr[j]>arr[j-1]){
                    swap(arr,j,j-1);
                }else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){//交换
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




}


