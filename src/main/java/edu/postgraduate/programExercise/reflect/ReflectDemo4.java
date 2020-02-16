package edu.postgraduate.programExercise.reflect;

import edu.postgraduate.programExercise.bean.Person;

import java.lang.reflect.Method;

/**
 *  如何获取类中的方法；如何调用类中的方法
 *  如何获取类的类名
 */
public class ReflectDemo4 {

    public static void main(String[] args) throws Exception {
        Class personClass = Class.forName("edu.postgraduate.programExercise.bean.Person");

        System.out.println("**********************************获取类/对象中的方法**********************************");

        System.out.println("-------获取指定名称的方法：方法名+参数列表-------");
        Method eatMethod = personClass.getMethod("eat");
        Method eatMethod1 = personClass.getMethod("eat", String.class);
        System.out.println("eatMethod: " + eatMethod);
        System.out.println("eatMethod1: " + eatMethod1);

        System.out.println("-------执行函数-------"); // 执行方法：一个对象 + invoke()函数 -> 函数的执行是一个运行时行为
        Person person = new Person();
        eatMethod.invoke(person); // 无参方法：传入一个对应类型的示例对象即可。
        eatMethod1.invoke(person, "牛排"); // 有参方法：除对应的实例对象外，还需要传入可用参数。

        System.out.println("-------获取所有公共方法-------");
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method); // 返回全名
            System.out.println(method.getName()); // 返回简名
//            method.setAccessible(true); // 暴力反射，用于破解私有类型的方法。
        }

        System.out.println("**********************************获取类的类名**********************************");
        String className = personClass.getName();
        System.out.println("className: " + className);
        System.out.println("personClass.toString(): " + personClass);
    }

}
