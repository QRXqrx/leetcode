package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * TCP编程实例3：客户端传输文件给服务器端，服务器接收完毕后告知客户端已接收
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-23
 */
public class TCPTest3 {


    @Test
    public void testClient() {
        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null; // 接收消息

        try {
            socket = new Socket(InetAddress.getLocalHost(), 8899);
            os = socket.getOutputStream();
            fis = new FileInputStream("Process.png");
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
            // 手动关闭数据输出，以免双方通信陷入死循环
            socket.shutdownOutput();

            // 然后再开启输入，读取来自服务器的信息
            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            while((len = is.read(bytes)) != -1) {
                baos.write(bytes, 0, len);
            }
            System.out.println(baos.toString()); // 打印来自服务器端的信息
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void testServer() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            // 将socket上面的内容写入程序
            is = socket.getInputStream();
            System.out.println("获取来自" +
                    socket.getInetAddress().getHostAddress()
            + "的文件...");
            // 将这个内容写出到文件，保存在物理内存上。
            fos = new FileOutputStream("pass_process1.png");
            byte[] bytes = new byte[1024];
            int len;
            while((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }

            System.out.println("传输完毕！");
            // 利用这socket（小船）给client带回消息(从程序写入数据到小船上，所以是输出)
            os = socket.getOutputStream();
            os.write("你的流程图我已收到，非常感谢！".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null) {
                // 关闭资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
