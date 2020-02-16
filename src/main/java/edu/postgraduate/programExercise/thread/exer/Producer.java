package edu.postgraduate.programExercise.thread.exer;

/**
 * 生产者
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-13
 */
public class Producer extends Thread{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        super();
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产...");
        while (true) {
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produce();
        }
    }
}
