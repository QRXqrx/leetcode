package edu.postgraduate.programExercise.reflect;

import edu.postgraduate.programExercise.bean.Person;

/**
 *  获取Class对象的三种方法：
 *         1.Class.forName("完整类名")：将字节码文件加载进内存，返回Class对象 // 类的定义阶段
 *         2.类名.class：通过类名属性class来获取 // 类的加载阶段
 *         3.对象.getClass()：用getClass()方法从对象中获取 // 类的运行时状态
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws Exception {
        // 1.Class.forName()
        Class clazz1 = Class.forName("edu.postgraduate.programExercise.bean.Person");
        System.out.println("1." + clazz1);
        // 2.类名.class
        Class clazz2 = Person.class;
        System.out.println("2." + clazz2);
        // 3.对象.getClass()
        Person p = new Person();
        Class clazz3 = p.getClass();
        System.out.println("3." + clazz3);

        System.out.println("******************每个对象只在内存中加载一次***********************");
        System.out.println("class1 == class2: " + (clazz1 == clazz2));
        System.out.println("class1 == class3: " + (clazz1 == clazz3));
    }
}
