package edu.postgraduate.programExercise.reflection.proxy.dynamicproxy;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-27
 */
public class SuperMan implements Movable{
    @Override
    public String belief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("I like eating " + food);
    }
}
