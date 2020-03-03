package edu.postgraduate.programExercise.bean;

import edu.postgraduate.programExercise.annotation.easycheck.Check;

public class Student extends Person{
    String id;

    public Student() {
    }

    @Check
    public void study() {
        System.out.println("学生的工作是学习");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("但是学生不能只想着吃！");
    }

    @Check
    private void fallInLove() {
        System.out.println("谈恋爱不敢告诉父母！");
    }
}
