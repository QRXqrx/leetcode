package edu.postgraduate.programExercise.reflection.proxy.staticproxy;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class ClothFactoryProxy implements ClothFactory {
    private ClothFactory factory;

    public ClothFactoryProxy(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些前期工作...");

        factory.produceCloth();

        System.out.println("代理工厂做一些后期工作...");
    }
}
