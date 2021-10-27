package com.sunchenchao.Lesson03;

import java.util.Arrays;

public class Code01_BigHeap {

    public static void main(String[] args) {
        int arr[] = {8,9,5,12,3,20,55,8,100};
        heapInsert(arr);
        System.out.println(Arrays.toString(arr));
        int heapify = heapify(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        heapInsert(arr);
        System.out.println(Arrays.toString(arr));
        heapifyNew(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    //注：如果就是把任意一个位置替换掉 然后让这个数字是大根堆就是使用向上的操作或者向下的操作就是
    //可以调整顺序 判断是比下面的数大还是小 来决定要进行的操作
    /**
     * 这个方法是对一个数进行heapinsert
     * @param arr
     * @param i
     */
    public static void heapInsert1(int[] arr,int i){
        while (arr[i] > arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void heapInsert(int[] arr){
        //没有去模拟那个结构只是用数组
        int len = arr.length;
        for (int i = 0;i < len;i++){
            int num = (i-1)/2;
            int p  = i;
            while (arr[p] > arr[num]){
                swap(arr,p,num);
                p = num;
                num = (num-1)/2;
            }
        }
    }

    /**
     * 获取最大值将最大值从头上摘除
     * 先将交换最后一个和第一的位置 返回最大值  然后heapSize--
     * 然后将内容heapify
     * @param arr
     * @param index  这个参数可以让我们从给定的位置开始heapify
     * @param heapSize
     * @return
     */
    public static int heapify(int[] arr,int index,int heapSize){
        int max = arr[0];
        swap(arr,index,heapSize);
        heapSize--;
        //交换heapsize
        //左边的值和右边的值进行比较 这边获取的是左右的最大值
        while (index < heapSize){
            int temp = index * 2 + 1 < heapSize ? (arr[index*2+1] > arr[index*2+2] ? index*2 +1 : index*2+2 ): index*2+1;
            if(arr[temp] <= arr[index]){
                return -1;
            }
            swap(arr,temp,index);
            index = index * 2+1;
        }
        return max;
    }

    /**
     * 这个是视频中的方法我觉得我的也不会有错
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapifyNew(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        swap(arr,0,heapSize--);
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left +1:left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(arr,largest,index);
            index = largest;
            left = index * 2 + 1;
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
