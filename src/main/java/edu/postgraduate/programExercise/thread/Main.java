package edu.postgraduate.programExercise.thread;

import edu.postgraduate.programExercise.thread.mythread.CallableThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-12
 */
public class Main {

    public static void main(String[] args) {
/*
        // 1.创建多线程的方式一
        Thread thread1 = new EvenNumThread();
        Thread thread2 = new OddNumberThread();

        thread1.start();
        thread2.start();
*/

/*
        // 2.创建多线程的方式二
        RunnableThread mt = new RunnableThread();
        Thread t1 = new Thread(mt, "线程1");
        Thread t2 = new Thread(mt, "线程2");
        t1.start();
        t2.start();
*/
/*
        // 卖票程序1
        SellerThread st1 = new SellerThread();
        st1.setName("窗口1");
        SellerThread st2 = new SellerThread();
        st2.setName("窗口2");
        st1.start();
        st2.start();
*/
        // 卖票程序2
//        TickSeller seller = new TickSeller();
//        Thread t1 = new Thread(seller, "窗口一");
//        Thread t2 = new Thread(seller, "窗口二");
//        Thread t3 = new Thread(seller, "窗口三");
//        t1.start();
//        t2.start();
//        t3.start();


        // callable 构造多线程
        Callable callable = new CallableThread();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        try {
            System.out.println("Sum: " + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
