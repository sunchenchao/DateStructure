package com.sunchenchao.Lesson02;

public class Code01_RecurrenceSerach {
    public static void main(String[] args) {
        int arr[] = {1,5,9,8,1,2,8,4,10};
        int i = RecurrenceSerach(arr, 1, 4);
        System.out.println(i);
    }

    /**
     * arr[l-r]的范围上寻找最大值
     * 这个就是使用递归的方式去求中间的值
     * @param arr
     */
    public static int RecurrenceSerach(int[] arr ,int  L,int R){
        if (L == R){
            return arr[L];
        }
        //这个也是一种抖机灵的写法  就是求中点数 防止越界的
        //就是相当于 l + ((r-l)/2)   或者就是最简单的求中点的写法
        int midPosition = L + ((R - L)>>1);
        int leftMax = RecurrenceSerach(arr, L, midPosition);
        int rightMax = RecurrenceSerach(arr, midPosition+1, R);
        return Math.max(leftMax,rightMax);
    }
    
}
