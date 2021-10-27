package com.sunchenchao.Lesson03;

import java.util.Arrays;

/**
 * 注意数据插入回去的细节记得从右往左取插入以确定数据的正确性
 */

public class Code05_RadixSort {
    // 基数排序就是桶排序
    public static void main(String[] args) {
        int arr[] = {11,45,889,87,41,7,6,778,12,44};
        radixSort(arr,0,arr.length-1,maxbits(arr));
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 求出这个数组中最大位是几位 然后返回
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr){
        int max = Integer.MIN_VALUE;
        int bit = 0;//这个用来记录有几位
        for (int i =0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        while (max!=0){
            max  = max / 10;
            bit++;
        }
        return bit;
    }

    /**
     * 传入一个数 获取第几位的数字  个位是第一位
     * @param num
     * @param bit
     * @return
     */
    public static int getDigit(int num,int bit){
        if (bit <=0){
            return -1;
        }
        if (bit == 1){
            return num % 10;
        }
        return (num / (10 * (bit-1))) % 10;
    }

    public static void radixSort(int[] arr,int start,int end,int maxBit){
        final int radix = 10;
        int o1 = 0,o2=0;


        //准备几个帮忙的数组
        int[] help = new int[end - start +1];


        //入桶出桶的次数
        for(int i =1;i<=maxBit ; i++){
            //准备10个桶
            //index 0 是为0的数有几个
            //index 1 是为0-1的数有几个
            //index 2 是为0-2的数有几个
            //以此类推
            int[] count = new int[radix];
            for(int j=start;j<= end;j++){
                int digit = getDigit(arr[j], i);
                count[digit]++;//统计出每一个有几个
            }
            //这边就是统计完成
            for (int j =1;j<radix;j++){
                count[j] =  count[j-1] + count[j];
            }
            //然后使用help数组进行新的排序
            for (int j=end ; j>=start ;j--){
                //注意这边要从 左往右取遍历这样才能保证数据的正确性 best best
                int digit = getDigit(arr[j], i);
                help[count[digit]-1] = arr[j];

                count[digit] --;

            }
            /**
             * 这个地方还是存在出入 等下来决定一下细节
             * 我决定这样给回去就是ok的 可以完成需求
             */
            for (int j = start; j <= end ; j ++){
                arr[j] = help[j];
            }
        }
    }
}
