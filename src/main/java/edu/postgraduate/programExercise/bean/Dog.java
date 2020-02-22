package edu.postgraduate.programExercise.bean;

import java.io.Serializable;

/**
 * Dog是一个可序列化的类
 * 可序列化必须实现Serializable接口，并赋予一个UID
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class Dog implements Serializable {

    public static final long serialVersionUID = 192384719287391827L;

    private String name;
    private int age;

    public Dog() {
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
