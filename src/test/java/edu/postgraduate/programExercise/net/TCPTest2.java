package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * TCP编程实例2：客户端发送文件（比如）给服务器端
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-23
 */
public class TCPTest2 {

    @Test
    public void testClient() {
        Socket socket = null;
        OutputStream os = null;// 取下装货管道
        FileInputStream fis = null;
        try {
            // 组件socket(运货小船)
            socket = new Socket(InetAddress.getLocalHost(), 8899);
            // 装载要传输的文件
            os = socket.getOutputStream();
            // 从要发送的文件中读数据
            fis = new FileInputStream("Process.png");
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1) {
                os.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
        try {
            // 1.开启服务器
            serverSocket = new ServerSocket(8899);
            // 2.接收服务器传输的socket
            socket = serverSocket.accept();
            System.out.println("接收到了来自" +
            socket.getInetAddress().getHostAddress()
            + "的数据");
            // 3.卸货
            is = socket.getInputStream();
            // 4.将数据储存在本地（储存到仓库）
            fos = new FileOutputStream("pass_process.png");
            byte[] bytes = new byte[1024];
            int len;
            while((len = is.read(bytes)) != -1) {
                fos.write(bytes, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fos != null)
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


