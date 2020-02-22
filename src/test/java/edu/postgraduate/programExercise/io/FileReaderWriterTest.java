package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-21
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReaderWriter1(){
        File srcFile = new File("Process.png");
        File destFile = new File("Process1.png");

        // 尝试使用字符流读写图片文件（错误）
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     }

    // 读出一个文件的内容，写入到另一个文件中去
    @Test
    public void testFileReaderWriter0() { // 文件复制
        // 1.创建File对象，指明读入和写出的文件
        File srcFile = new File("hello.txt");
        File destFile = new File("hello1.txt");

        // 2.创建输入输出流对象
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            // 3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; // 记录每次读入了多少字符
            while((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len); // 保证写入的都是读出的
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.资源的关闭
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFileWriter() {
        File file = new File("dream.txt");
//        FileWriter fw = new FileWriter(file);
//        FileWriter fw = new FileWriter(file, false);
        FileWriter fw = null; // append to existing file
        try {// 如果alt + enter的时候，代码中包含了关闭资源的操作，则会提示为try-with-resources；否则为try-catch
            fw = new FileWriter(file, true);
            fw.write("I have dream\n");
            fw.write("You need a dream, too");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /*
    The try-with-resources statement is a try statement that declares one or more resources.
    A resource is an object that must be closed after the program is finished with it.
    The try-with-resources statement ensures that each resource is closed at the end of the
    statement. Any object that implements java.lang.AutoCloseable, which includes all objects
    which implement java.io.Closeable, can be used as a resource.
     */
    @Test
    public void testFileReader1() {
        File file = new File("hello.txt");
        try (FileReader fr = new FileReader(file)) { // try-with-resources clause 会保证在操作的最后关闭资源，
                                                    // 相当于try-catch-finally。这个资源对象一定要实现了closeable接口，
                                                    //同时异常需要继续处理
            char[] cbuf = new char[5];
            int len;
//            fr.read(cbuf, offset: 0, length: 3); 按照偏移量和长度，只利用cbuf中的部分区域
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                System.out.println();
//                System.out.println(cBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFileReader0() {
        FileReader reader = null;
        File file = new File("hello.txt");
//        System.out.println(file.getAbsolutePath());
        try{
            reader = new FileReader(file);
            int data;
            while((data = reader.read()) != -1) {
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
                try {
                    if(reader != null)
                        reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
