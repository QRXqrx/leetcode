package edu.postgraduate.programExercise.reflection.proxy;

import edu.postgraduate.programExercise.reflection.proxy.dynamicproxy.DynamicProxy;
import edu.postgraduate.programExercise.reflection.proxy.dynamicproxy.Movable;
import edu.postgraduate.programExercise.reflection.proxy.dynamicproxy.SuperMan;
import edu.postgraduate.programExercise.reflection.proxy.staticproxy.ClothFactory;
import edu.postgraduate.programExercise.reflection.proxy.staticproxy.NikeClothFactory;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Movable movableProxy = (Movable) DynamicProxy.getProxyInstance(superMan);// 传入被代理类对象
        System.out.println(movableProxy.belief());
        movableProxy.eat("steak");

        System.out.println("*****************************"); // 也可以调用静态代理里面定义的类
        NikeClothFactory factory = new NikeClothFactory();
        ClothFactory clothFactoryProxy = (ClothFactory) DynamicProxy.getProxyInstance(factory);
        clothFactoryProxy.produceCloth();
    }
}
