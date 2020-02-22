package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.*;

/**
 * InputStreamReader
 * 1.以Reader结尾，所以是处理字符的流。
 * 2.是转换流，属于处理流的一种，因此需要构建在节点流基础上。
 * 3.nputStreamReader主要用于解码，可以按照指定的编码集从文件中读取内容。
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class InputStreamReaderTest {

    @Test
    public void testChangeEncoding() {
        File srcFile = new File("Git指令.txt");
        File destFile = new File("Git指令_gbk.txt");

        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            // 以utf-8格式读入
            isr = new InputStreamReader(new FileInputStream(srcFile), "utf-8");
            // 以gbk格式写出
            osw = new OutputStreamWriter(new FileOutputStream(destFile), "gbk");

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1) {
                osw.write(cbuf, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1() {
        InputStreamReader isr = null; // 显示指定字符集
        try {
            FileInputStream fis = new FileInputStream("Git指令.txt");
//        InputStreamReader isr = new InputStreamReader(fis); // 使用默认字符集读取，与系统（IDE）设置有关
//            isr = new InputStreamReader(fis, "gbk"); // 使用错误的字符集会导致乱码
            isr = new InputStreamReader(fis, "UTF-8");

            char[] cbuf = new char[20];
            int len;
            while((len = isr.read(cbuf)) != -1) {
                System.out.println(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭外层的同时，自动帮助编码人员关闭内部资源
            if(isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
