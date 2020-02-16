package edu.postgraduate.programExercise.thread.mythread;

/**
 * 卖票窗口，可以实现多线程买票。继承Thread产生卖票线程类，要用static
 * TODO 线程安全问题
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-12
 */
public class SellerThread extends Thread {
    private static int totalNum = 100;

    @Override
    public void run() {
        while(totalNum > 0) {
            System.out.println(getName() + "卖票，卖出票号为：" + totalNum);
            totalNum--;
        }
    }
}
