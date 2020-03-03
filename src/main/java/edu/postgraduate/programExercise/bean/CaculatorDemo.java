package edu.postgraduate.programExercise.bean;

import edu.postgraduate.programExercise.annotation.easycheck.Check;

public class CaculatorDemo {

    public CaculatorDemo() {
    }

    @Check
    public void add() {
        String str = null;
        str.length();
        System.out.println("1 + 1 = " + (1 + 1));
    }
    @Check
    public void sub() {
        System.out.println("1 - 1 = " + (1 - 1));
    }
    @Check
    public void mul() {
        System.out.println("1 * 2 = " + (1 * 2));
    }
    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    public void show() {
        System.out.println("Show");
    }

}
