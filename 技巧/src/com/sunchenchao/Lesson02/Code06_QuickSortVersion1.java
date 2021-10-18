package com.sunchenchao.Lesson02;

import java.util.Arrays;

/**
 * 这边是直接优化到快排3.0版本
 * 1.0 版本就是不对中间的数据进行排序
 * 2.0 版本就是对中间的数进行排序
 * 数据都是取最后一个来做划分值 时间复杂度就是O(N^2)
 *终极3.0版本就是通过 随机数来进行确定划分之 对数据进行一次交换
 * 经过数学的推导长期期望 时间复杂度就是O(N*LogN)
 */

public class Code06_QuickSortVersion1 {
    public static void main(String[] args) {
        int[] arr = {10,1,5,8,8,2,145,55,5,2};
        quickSort(arr,0,arr.length-1);
        String s = Arrays.toString(arr);
        System.out.println(s);

    }
    public static void quickSort(int arr[],int L,int R){
     if (L < R){
         swap(arr,L + (int)(Math.random()* (R - L +1)),R);//产生随机交换位置的随机数
         int[] p = partition(arr,L,R); //回返回两个数 一个数是左边的边界 一个数是右边的边界

         String s = Arrays.toString(p);
         System.out.println(s);
         //下面给到的数的下标是打在相同的数的身上的  所以这边需要取再减一个或加上一个来
         //求出边界
         quickSort(arr,L,p[0]-1);
         quickSort(arr,p[1]+1,R);
     }
    }
    public static int[] partition(int[] arr,int L ,int R){
        //----------------这块地方的写法还是比较多的 循环什么的都是可以实现的----------------
//        System.out.println(L+"--"+R);
        int less = L-1;  //左区边界 L就是每次便利的位置 这边减一的目的就是为了下面的交换数据
                         //写法右好多种 这边这个交换  我就不改了
        int more = R;   //右取边界
        while (L < more){
            if(arr[L] < arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L] > arr[R]){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        //真实给到的位置并不是真的位置而是刚好是相同的数的位置
        //也可以这边直接给到真实的边界
        return new int[] {less+1,more};
    }


    public static void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] =  arr[j];
        arr[j] =temp;
    }
}


