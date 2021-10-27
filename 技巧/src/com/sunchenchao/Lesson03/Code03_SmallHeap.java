package com.sunchenchao.Lesson03;

import java.util.PriorityQueue;

/**
 * 一个数组 这个数组排完序每个数组的位次移动不超过q 就能使这个数字有序 求时间复杂度最小
 * 系统也是提供大根堆 但是大根堆是不太好 灵活性不是很高
 */
public class Code03_SmallHeap {

    public void sortedArrDistanceLessK(int[] arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        //先将前几个插入小根堆
        for (;index<=Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        //这个是k以外的数字
        int i = 0;
        for (;index<arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        //然后将剩下的数字弹出 看最小的时间复杂度
        while (!heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }

}
