package edu.postgraduate.programExercise.interfacetest;

import edu.postgraduate.programExercise.interfacetest.example.Flash;
import edu.postgraduate.programExercise.interfacetest.example.USB;

public class Main {
    public static void main(String[] args) {
        // 1.创建(USB)接口的非匿名实现类的非匿名对象
        Flash flash = new Flash();
        flash.work();

        // 2.创建非匿名实现类的匿名对象
        new Flash().work();

        // 3.创建非匿名实现类的非匿名对象
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("Phone start working...");
            }

            @Override
            public void stop() {
                System.out.println("Phone stop working...");
            }

            @Override
            public void process() {
                System.out.println("Phone's working process");
            }
        };
        phone.process();

        // 4.创建匿名实现类的匿名对象
        new USB() {
            @Override
            public void start() {

            }

            @Override
            public void stop() {

            }

            @Override
            public void process() {
                System.out.println("Computer's working process");
            }
        }.process();
    }


}
