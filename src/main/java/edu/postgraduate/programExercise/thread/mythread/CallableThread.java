package edu.postgraduate.programExercise.thread.mythread;

import java.util.concurrent.Callable;

/**
 * 通过实现Callable接口的方式实现多线程的构造。
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-13
 */
public class CallableThread implements Callable{
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for(int i = 2 ; i <= 100 ; i++) {
            if(i % 2 == 0) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}
