package edu.postgraduate.programExercise.reflect;

import edu.postgraduate.programExercise.bean.Person;

import java.lang.reflect.Constructor;

/**
 *  如何利用反射机制获取一个类的有参构造器、无参构造器；如何使用构造器类构造对象
 */
public class ReflectDemo3 {

    public static void main(String[] args) throws Exception {
        Class personClass = Class.forName("edu.postgraduate.programExercise.bean.Person");
        System.out.println("*****************************获取构造方法*****************************");
        // 由于构造方法也是能重载的，所以在已知构造方法名为类名的情况下，确定一个构造方法就需要接着确定参数列表。
        Constructor personConstructor = personClass.getConstructor(String.class, int.class);
        System.out.println("person constructor: " + personConstructor);
        Person person = (Person) personConstructor.newInstance("Adian", 22);
        System.out.println(person);
        // 空参构造的两种方法
        // 1.获取构造器 -> 构造
        Constructor personConstructor1 = personClass.getConstructor();
        Person person1 = (Person) personConstructor1.newInstance();
        // 2.直接用Class中的newInstance（直接获取空参构造器）
        Person person2 = (Person) personClass.newInstance();
        System.out.println(person1);
        System.out.println(person2);
        if(person1 == person2) {
            System.out.println("person1 and person2 are the same object.");
        }
        if(person1.equals(person2)) {
            System.out.println("person1 and person2 have same content.");
        }

//        personConstructor.setAccessible(); // 构造器类中也有一个设置访问权限的方法。可以用于暴力反射私有构造器
    }

}
