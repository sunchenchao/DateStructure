package com.sunchenchao.Lesson02;

import com.sun.deploy.util.ParameterUtil;

import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度O(N*logN)
 * 这个是使用master递归公式来进行操作
 * 为什么要比冒泡什么的要好因为没有浪费任何一次比较
 */
public class Code02_MergeSort {
    public static void main(String[] args) {
        int[] arr ={1,596,989,9,7,9,4,79,2,6,34,4,4};
        MergeSort(arr,0,arr.length-1);
        String s = Arrays.toString(arr);
        System.out.println(s);

    }

    public static void MergeSort(int[] arr,int L,int R){
        if (L == R){
            return;
        }
        int innerMid = L + ((R - L)>>1);
        MergeSort(arr,L,innerMid);
        MergeSort(arr,innerMid+1,R);
        Merge(arr,L,innerMid,R);

    }
    public static void Merge(int[] arr,int L,int innerMid,int R){
        int[] help =  new int[R-L+1];
        int helP = 0;
        int LP = L;
        int MP =innerMid + 1;
        while (LP<=innerMid && MP <= R){ // 注意这边是要两个都要满足才可以操作的
            if (arr[LP] < arr[MP]){
                help[helP++] = arr[LP++];
            }else{
                help[helP++] = arr[MP++];
            }
        }
        while (LP <= innerMid){
            help[helP++] = arr[LP++];

        }
        while (MP <= R){
            help[helP++] = arr[MP++];
        }
        for (int i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }
    }
}
