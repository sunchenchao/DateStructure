package com.sunchenchao.Lesson03.pojo;

import java.util.StringJoiner;

public class Student {
    private Integer age;

    public Student(Integer age, Integer score) {
        this.age = age;
        this.score = score;
    }

    private Integer score;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student() {
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("age=" + age)
                .add("score=" + score)
                .toString();
    }
}
