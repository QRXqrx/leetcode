package edu.postgraduate.programExercise.abstracttest.example.timer;

/**
 *  利用abstract关键字，完成模板设计方法 - 某个计算流程已经确定，但是流程中有一部分代码是不固定的，很易变。
 *  需求：该计时器可以计算一个方法执行的时间
 *  特点：
 *      1.计时的流程是固定的
 *      2.执行的方法是不固定的
 */
public abstract class TimerTemplate {

    public void printTime() {
        long begin = System.currentTimeMillis();
        method();
        long end = System.currentTimeMillis();
        System.out.println("用时: " + (end - begin) + "(ms)");
    }

    public abstract void method();
}
