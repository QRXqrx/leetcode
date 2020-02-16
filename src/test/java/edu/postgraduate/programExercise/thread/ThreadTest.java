package edu.postgraduate.programExercise.thread;

import edu.postgraduate.programExercise.thread.mythread.EvenNumThread;
import edu.postgraduate.programExercise.thread.mythread.OddNumberThread;
import org.junit.Test;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-12
 */
public class ThreadTest {

    @Test
    public void testTwoThread() {
        Thread thread1 = new EvenNumThread();
        Thread thread2 = new OddNumberThread();

        thread1.start();
        thread2.start();
    }
}
