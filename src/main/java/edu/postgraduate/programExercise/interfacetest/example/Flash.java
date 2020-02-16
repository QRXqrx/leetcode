package edu.postgraduate.programExercise.interfacetest.example;

/**
 *  Flash具有USB的工作特性，需要满足USB工作规范
 */
public class Flash extends Device implements USB{

    @Override
    public void start() {
        System.out.println("Flash start working...");
    }

    @Override
    public void stop() {
        System.out.println("Flash stop working ");
    }

    @Override
    public void process() {
        System.out.println("Flash's working process");
    }

    @Override
    public void work() {
        start();
        process();
        stop();
    }
}
