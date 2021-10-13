package com.sunchenchao.Lesson01;

public class Test {
    public static void main(String[] args) {

    }
    //这两个去比较就直接去运行去比较就是ok 不要再去比较每个运行的复杂度是不一样的
    public static void run1(){
        process1();
        process2();
    }

    public static void process1(){
        int N = 10000;
        for(int i = 0;i<N;i++){
            int sum = 0;
            sum ++;
        }
    }
    public static void process2() {
        int N = 10000;
        for (int i = 0; i < N; i++) {
            int a = 0;
             a= 3 | 1;
        }
    }
}
