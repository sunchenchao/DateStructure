package com.sunchenchao.Lesson03;

import java.util.Arrays;

/**
 * 时间复杂度log(nLogN)
 * 额外空间复杂度O(1)
 */
public class Code02_HeapSort {
    public static void main(String[] args) {
        int[] arr =  {7,8,9,5,3,1,6,11};
        if (arr==null || arr.length<2){
            return;
        }
        for(int i=0;i<arr.length;i++){//O(n)
            heapinsert(arr,i);//O(n)
        }
        //另外一种方法变成大根堆 就是从下网上 这个数字不是一个一个给你 而是一股脑的给你
        //下面整体方法的复杂度就是O(N)级别的复杂度
        //n/2 1 两个层只要对比1个 n/4 2 第三层只要对比2个
//        for(int i = arr.length-1;i>=0;i--){
//            heapify(arr,i,arr.length-1);
//        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){//O(n)
            heapify(arr,0,heapSize);//O(logn)
            swap(arr,0,--heapSize);
        }
        System.out.println(Arrays.toString(arr));


    }

    public static void heapinsert(int[] arr,int i){
        while (arr[i] > arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    /**
     * heapify 前面已经交换位置所以不需要交换
     * @param arr
     * @param index
     * @param heapSize
     */
    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
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
