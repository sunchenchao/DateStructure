package com.sunchenchao.Lesson02;

import java.util.Arrays;

/**
 * 上一个题目的升级版 如果出现1 2 4 5 5 5 5 7 8 9
 * 将分割的数放在最中间 如果没有加就是不管
 */
public class Code05_ArrSmallEquipBig {
    public static void main(String[] args) {
        int[] arr = {
                5,5,5,9,6,3,1,4,8,66,5,44,1
        };
        ArrSmallEquipBig(arr,5);
        String s = Arrays.toString(arr);

        System.out.println(s);

    }

    public static void ArrSmallEquipBig(int arr[],int findNum){
        int start = 0;
        int end = arr.length - 1;
        int endd = arr.length;
        for(int i = 0;i<endd;i++){//记住这边就是细节  一旦后面完成就是这个endd 要被压缩
            if(arr[i]<findNum){
                swap(arr,i,start++);
            }else if (arr[i]>findNum){
                swap(arr,i,end--);
                endd--;
            }
        }
    }
    public static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
