package edu.postgraduate.programExercise.reflection.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object obj;// 被代理类对象

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 通过这个方法处理代理类的方法调用。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 那么实际上代理类需要做的一些额外处理应该写在这里吗？
        /*
            可以在这里加入通用代码，位置1
         */
           Object returnValue = method.invoke(obj, args);
        /*
            可以在这里加入通用代码，位置2
         */
        return returnValue;
    }
}
