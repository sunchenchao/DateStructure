package com.sunchenchao.Lesson02;

public class Code03_SmallSumByMergeSort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int i = SmallAllMergeSort(arr, 0, arr.length - 1);
        System.out.println(i);
    }
    /**
     * 求小和问题使用归并排序进行操作 这个是左边比右边小
     * 还有一个相反的问题就是求逆序对  这个是左边比右边大
     */
    public static int SmallAllMergeSort(int[] arr,int L,int R){
        if(L==R){
            return 0;
        }
        int M = L + ((R-L)>>1);
        int Lsum = SmallAllMergeSort(arr, L, M);
        int Rsum = SmallAllMergeSort(arr, M + 1, R);
        int Nsum = SmallAllMerge(arr,L,M,R);
        return Lsum + Rsum + Nsum;
    }
    public static int SmallAllMerge(int[] arr,int L,int M,int R){
        int[] help = new int[R-L+1];
        int p = 0;
        int lp = L;
        int rp= M+1;
        int smallSum = 0;
        while (lp<=M && rp<=R){
            // 这边是可以使用三木运算符去优化这个结构的
            if (arr[lp]<arr[rp]){
                smallSum = smallSum + arr[lp]*(R-rp+1);
                help[p++] = arr[lp++];
            }else {
                help[p++] = arr[rp++];
            }
//            if(arr[lp]==arr[rp]){//在相等的情况下就是先将右边的放过去 也可以和下面的和并的
////                //1111111 111122 这个情况很特殊是不会存在数据的
////                help[p++] = arr[rp++];
////            }
//            if (arr[lp]>arr[rp]){
//                help[p++] = arr[rp++];
//            }
        }
        while (lp <= M){
            help[p++] = arr[lp++];

        }
        while (rp <= R){
            help[p++] = arr[rp++];
        }
        for (int i = 0;i<help.length;i++){
            arr[L+i] = help[i];
        }
        return smallSum;
    }
}
