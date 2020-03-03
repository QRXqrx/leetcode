package edu.postgraduate.programExercise.reflection.proxy.staticproxy;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike生产一批球鞋！");
    }
}
