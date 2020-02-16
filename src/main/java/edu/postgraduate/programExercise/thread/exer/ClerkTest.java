package edu.postgraduate.programExercise.thread.exer;

/**
 * 生产者-消费者问题。
 *
 * 1.多线程解决这一问题。
 * 2.处理进程安全问题 - synchronized
 * 3.处理进程间的通讯 - wait() & notify()
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-13
 */
public class ClerkTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer1 = new Producer(clerk);
        Consumer consumer1 = new Consumer(clerk);
        Consumer consumer2 = new Consumer(clerk);

        producer1.setName("生产者1");
        consumer1.setName("消费者1");
        consumer2.setName("消费者2");

        producer1.start();
        consumer1.start();
        consumer2.start();
    }
}
