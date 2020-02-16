package edu.postgraduate.programExercise.interfacetest.example.proxy;

/**
 * 应用interface，实现代理模式，完成网络连接相关应用
 * 网络接口
 *
 * 代理模式的代理类为其他类完成对某一个对象的访问
 * 代理类实际上帮助被代理类完成了一些其他的操作，这些操作可能是被代理类不关心的，因此不会在被代理类中实现
 * 特点
 *  1.代理类 & 被代理类
 *  2.被代理类与代理类实现同一接口，要实现共同的方法
 */
public interface Network {
    void browse();
}
