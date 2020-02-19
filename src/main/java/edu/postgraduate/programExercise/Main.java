package edu.postgraduate.programExercise;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-19
 */
public class Main {

    public Main() {
        printThis();
    }

    public static void main(String[] args) {
        new Main();
        new Main();
        new Main().printThis();
        new Main().printThis();
    }

    public void printThis() {
        System.out.println(this);
    }
}
