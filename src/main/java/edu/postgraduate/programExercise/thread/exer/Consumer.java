package edu.postgraduate.programExercise.thread.exer;

/**
 * 消费者
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-13
 */
public class Consumer extends Thread{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        super();
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费...");
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }
    }
}
