package edu.postgraduate.programExercise.bean;

public class Student extends Person{
    String id;

    public void study() {
        System.out.println("学生的工作是学习");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("但是学生不能只想着吃！");
    }
}
