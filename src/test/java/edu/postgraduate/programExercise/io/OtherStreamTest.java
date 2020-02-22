package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class OtherStreamTest {


    /*
        将持久化的基本数据类型读入内存
        读取顺序必须和写入顺序一致
     */
    @Test
    public void testDataInputStream() {
        DataInputStream dis = null;
        String name = null;
        int age = 0;
        boolean isMale = false;
        try {
            dis = new DataInputStream(new FileInputStream(new File("data.txt")));

            name = dis.readUTF();
            age = dis.readInt();
            isMale = dis.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);

    }

    /*
        将基本数据类型从内存写入物理存储，即持久化
        DataOutputStream写出的数据需要通过DataInputStream读入到内存才能正确显示
     */
    @Test
    public void testDataOutputStream() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));

            dos.writeUTF("QRX"); // 写出一个字符串
            dos.flush(); // 写入后刷新内存
            dos.writeInt(22); // 写出一个整型
            dos.flush();
            dos.writeBoolean(true); // 写出一个布尔型
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
        重定向标准输出
     */
    @Test
    public void testRedirectStdPrint() {
        try (PrintStream ps = new PrintStream(new FileOutputStream(new File("redirtToHere.txt")), true)) {
            if (ps != null) {
                System.setOut(ps); // 重新定位标准输出，使系统的输出对接到这个文件
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 20 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
