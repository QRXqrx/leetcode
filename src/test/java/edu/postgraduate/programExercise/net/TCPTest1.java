package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * TCP传输编程实例1：客户端给服务器段传输消息，服务器端接收消息并打印。
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class TCPTest1 {


    @Test
    public void testClient() {

        // 创建socket（造船运货，运往指定港口）
        Socket socket = null; // 与服务器端口保持一致。inet表示服务器IP

        try {
            InetAddress inet = InetAddress.getLocalHost();
            socket = new Socket(inet, 8899);

            // 获取输出流，向内写入数据（向船上装货）
            OutputStream os = socket.getOutputStream();
            os.write("我是客户端".getBytes()); // 传输二进制流
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                // 关闭socket资源
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
        ByteArrayOutputStream baos = null; // 直接从内部数组输出，所以不需要节点流

        try {
            // 创建服务器套接字，声明服务器自己的端口号
            serverSocket = new ServerSocket(8899);
            // 获取来自客户端的Socket(接船入港)
            socket = serverSocket.accept();
            System.out.println( "接收来自" +
                    socket.getInetAddress().getHostAddress()
            + "的信息");
            // 从客户端套接字处获取信息（从船上卸货）
            is = socket.getInputStream();
            // 将数据转化输出
        /*  不建议使用这种，因为在传输过程中可能因为截断而产生乱码
        byte[] bytes = new byte[1024];
        int len;
        while((len = is.read(bytes)) != -1) {
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
        */

            // 使用ByteArrayOutputStream接收，他会将所有字节存储到一个字节数组中，最后一次性输出
            baos = new ByteArrayOutputStream();
            int len;
            byte[] bytes = new byte[5];
            while((len = is.read(bytes)) != -1) {
                baos.write(bytes); // 不断拼接
            }
            System.out.println(baos.toString()); // 输出内部的字节数组，转换为可读文本
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null) {
                // 关闭资源
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
