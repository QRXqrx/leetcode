package edu.postgraduate.programExercise.statictest.example;

/**
 *  通过单例模式(Singleton)编写一个bank类
 *  单例模式的实现方式
 *      1.饿汉式 -> 缺：加载时间过长
 *              -> 优：天然线程安全
 *      2.懒汉式 -> 优：延迟对象创建
 *                 缺：目前的写法会导致线程不安全
 *
 */
public class Order { // 懒汉式单例模式实现
    // 1.构造器私有化 -> 防止从外部构造对象。
    private Order() {

    }

    // 2.在内部静态构造的Bank实例。
    private static Order instance = null;


    // 3.设置静态的get方法。
    public static Order getInstance() {
        if(instance == null) { // 改写成线程安全的
            synchronized (Order.class) {
                if(instance == null) {
                    instance = new Order();
                }
            }
        }
        return instance;
    }
}
