package edu.postgraduate.programExercise.enumtest;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-15
 */
public class Main {

    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);

        for (Season season : Season.values()) {
            System.out.println(season);
            season.show();
        }
    }
}
