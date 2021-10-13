package com.sunchenchao.Lesson01;

public class Code03_SwapBit {
    public static void main(String[] args) {

    }
    //这个就是交换
    public static void swap(int[] arr ,int i , int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
