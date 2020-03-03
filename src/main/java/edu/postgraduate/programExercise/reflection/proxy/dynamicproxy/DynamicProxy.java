package edu.postgraduate.programExercise.reflection.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class DynamicProxy {

    // 这个方法可以动态的获取代理类对象
    public static Object getProxyInstance(Object obj) { // 这个参数就是被代理类

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj); // 将handler与被代理类绑定

        return Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                handler// 这个地方需要一个InvocationHandler，用于处理方法调用
        );
        // 猜测是newProxyInstance里面用到了handler.invoke中的proxy这个参数
    }
}
