package edu.postgraduate.programExercise.reflect;

import edu.postgraduate.programExercise.bean.Person;

import java.lang.reflect.Field;

/**
 *  如何利用反射机制获取一个对象中的成员变量；如何使用这些成员变量。
 */
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {
        Class personClass = Class.forName("edu.postgraduate.programExercise.bean.Person");
        System.out.println("-------------------------获取公共成员变量--------------------------");
        Field[] publicFields = personClass.getFields();

        for (Field publicField : publicFields) {
            System.out.println(publicField);
        }
        System.out.println("***********使用成员变量*********** ");
        Field publicStrFiled = personClass.getField("publicStr");
        // 获取成员变量的值，必须要从对应的对象中获取。因为只有对象的变量才有值
        Person person = new Person("init");
        Object publicStrValue = publicStrFiled.get(person);
        System.out.println("publicStrValue: " + publicStrValue);
        // 为某个对象的对应成员变量赋值
        publicStrFiled.set(person, "set");
        System.out.println("After set: " + person.toString());

        System.out.println("-------------------------获取所有成员变量-------------------------");
        // 反射面前没有什么是私有的
        Field[] declareFileds = personClass.getDeclaredFields();
        for (Field declareFiled : declareFileds) {
            System.out.println(declareFiled);
        }

        // 获取单个私有变量以操作
        Field privateStrFiled = personClass.getDeclaredField("privateStr");
        privateStrFiled.setAccessible(true); // 暴力反射，忽略访问权限修饰的安全限制。如果不重设访问权限，执行时会抛出异常
        Object privateStrValue = privateStrFiled.get(person);
        System.out.println("privateStrValue: " + privateStrValue);
    }
}
