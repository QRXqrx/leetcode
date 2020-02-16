package edu.postgraduate.programExercise.thread.exer;

/**
 * 生产者-消费者程序中，操作产品的Clerk类
 * @see Consumer
 * @see Producer
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-13
 */
public class Clerk {
    private int productNum = 0;

    public synchronized void consume() {
        if(productNum > 0) {
            System.out.println(Thread.currentThread().getName() + "消费了第" + productNum + "号产品");
            productNum--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void produce() {
        if(productNum < 20) {
            productNum++;
            notify();
            System.out.println(Thread.currentThread().getName() + "生产了第" + productNum + "号产品");
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
