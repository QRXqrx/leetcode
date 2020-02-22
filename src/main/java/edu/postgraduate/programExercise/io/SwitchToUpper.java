package edu.postgraduate.programExercise.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 将键盘输入的英文字符转换成大写，输入e或者exit退出。
 *
 * 1.System.in标准输入是一个InputStream。如果希望使用BufferReader的readline方法，需要经过
 *   InputStream -> 转换流 -> Reader（节点流） -> 处理流包装 -> BufferedReader
 * 2.idea单元测试支持控制台输入，因此改到main里面进行测试
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class SwitchToUpper {

    public static void main(String[] args) {

        BufferedReader br = null; // 处理成缓冲流
        try {
            InputStreamReader isr = new InputStreamReader(System.in); // 转换成字符流
            br = new BufferedReader(isr);
            String line;
            System.out.println("请输入英文字符串：");
            while((line = br.readLine()) != null) {

                boolean isExit = ("e".equalsIgnoreCase(line) || "exit".equalsIgnoreCase(line));
                if(isExit) {
                    break;
                }
                System.out.println(line.toUpperCase());
                System.out.println("请输入英文字符串：");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 关闭外部处理流，内部流自动关闭
    }

}
