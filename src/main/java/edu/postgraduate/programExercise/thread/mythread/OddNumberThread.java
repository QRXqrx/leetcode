package edu.postgraduate.programExercise.thread.mythread;

/**
 * Simple thread class, print odd number less than 1000.
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-12
 */
public class OddNumberThread extends Thread{
    @Override
    public void run() {
        for(int i = 0 ; i < 1000; i++) {
            if(i % 2 == 1) {
                System.out.println(Thread.currentThread() + ": " + i);
            }
        }
    }
}
