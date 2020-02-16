package edu.postgraduate.programExercise.statictest.example;

/**
 *  通过单例模式(Singleton)编写一个bank类
 *  单例模式的实现方式
 *      1.饿汉式 -> 加载时间过长
 *      2.懒汉式 -> 延迟对象创建
 */
public class Bank { // 饿汉式单例模式实现
    // 1.构造器私有化 -> 防止从外部构造对象。
    private Bank() {

    }

    // 2.在内部静态构造的Bank实例。
    private static Bank instance = new Bank();


    // 3.设置静态的get方法。
    public static Bank getInstance() {
        return instance;
    }
}
