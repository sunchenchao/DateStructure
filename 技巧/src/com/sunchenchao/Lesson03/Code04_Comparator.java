package com.sunchenchao.Lesson03;

import com.sunchenchao.Lesson03.pojo.Student;

import java.util.Arrays;
import java.util.Comparator;

public class Code04_Comparator {
    public static void main(String[] args) {
        Student student1 = new Student(11,50);
        Student student2 = new Student(11,60);
        Student student3 = new Student(11,90);
        Student student4 = new Student(11,8);
        Student[] student = new Student[]{
            student1,student2,student3,student4
        };
        Arrays.sort(student, new myCompato());
        System.out.println(Arrays.toString(student));

    }


}
class myCompato implements Comparator<Student> {
    /**
     * 返回负数的时候 第一个参数排在前面
     * 返回正数的时候 第二个参数排在前面
     * 返回0 的时候无所谓
     * @param o1
     * @param o2
     * @return
     */

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore() - o2.getScore();
    }
}