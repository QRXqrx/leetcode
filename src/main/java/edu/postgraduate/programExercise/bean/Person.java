package edu.postgraduate.programExercise.bean;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    String name;
    int age;

    public String publicStr;
    protected String protectedStr;
    String defaultStr;
    private String privateStr;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Person(String publicStr) {
        this.publicStr = publicStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", publicStr='" + publicStr + '\'' +
                ", protectedStr='" + protectedStr + '\'' +
                ", defaultStr='" + defaultStr + '\'' +
                ", privateStr='" + privateStr + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    public void eat() {
        System.out.println("人需要吃....");
    }

    public void eat(String food) {
        System.out.println("人可以吃" + food);
    }

    private String showNation(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }


    private static void showDesc() {
        System.out.println("我是一个可爱的人...");
    }
}
