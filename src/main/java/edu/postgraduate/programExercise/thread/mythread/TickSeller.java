package edu.postgraduate.programExercise.thread.mythread;

/**
 * 卖票窗口，可以实现多线程买票。实现Runnable接口，使一个卖票窗口可以多线程运行（Runnable的含义）
 * TODO 线程安全问题
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-12
 */
public class TickSeller implements Runnable {
    private int totalNum = 100;

    @Override
    public void run() {
        while(totalNum > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，卖出票号为：" + totalNum);
            totalNum--;
        }
    }
}
