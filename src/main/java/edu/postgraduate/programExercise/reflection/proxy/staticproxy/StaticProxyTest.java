package edu.postgraduate.programExercise.reflection.proxy.staticproxy;

/**
 * 被代理类对象被封装在代理类对象中。调用代理类对象的方法，实际上是调用了被代理类对象的方法 + 其他操作
 * 静态代理的特点：被代理类和代理类在编译期间就确定下来了
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        // 创建被代理类对象
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        // 创建代理类对象
        ClothFactoryProxy clothFactoryProxy = new ClothFactoryProxy(nikeClothFactory);

        clothFactoryProxy.produceCloth();
    }
}
