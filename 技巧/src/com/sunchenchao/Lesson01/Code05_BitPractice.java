package com.sunchenchao.Lesson01;

import java.util.Arrays;

public class Code05_BitPractice {
    public static void main(String[] args) {
        int[] arr = {1,1,3,4,4};
        problemOne(arr);

        int[] arr2 = {1,1,6,5,5,7};
        problemTwo(arr2);
    }
    /**
     * 给定一个数组里面有一个数出现了奇数次 其他的数都是出现了偶数次
     * 让我们求出这个数是什么
     * @param arr
     */
    public static void problemOne(int[] arr){
        int num = arr[0];//这边一开始复制为0 然后0^任何数都是自己本身
        for (int i = 1;i<arr.length;i++) {
            num = num ^ arr[i];
        }
        System.out.println(num);
    }
    /**
     * 有两个数是奇数次，其他数都是偶数次求这个两个数是多少？
     * @param arr
     */
    public static void problemTwo(int[] arr){
        int eor=0;
        for (int item: arr) {
            eor = eor ^ item;// 这边得到的结果就是 两个奇数的a^b
        }
        //a 和 b必有一位上是不同的   我这边设他为第8位 这样 eor^当第八位为1的数 剩下得出的就是a或b
        int rightOne = 0; // 这个存放左右侧为1的数
        rightOne = eor & (~eor + 1); // 最右侧为1的数 常规操作
        int eorOther = 0;
        for (int item : arr){
            if ((item & rightOne)!=0){//这边的条件不等于0 和 等于0都是可以的
                eorOther = eorOther ^ item;
            }
        }
        //最后得出的就是两个数
        eor = eor ^ eorOther;
        System.out.println("第一个奇数为："+eor);
        System.out.println("第二个奇数为："+eorOther);
    }
}
