package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class FileInputOutputTest {

    @Test
    public void testCopyFile() {
        String src1 = "hello.txt";
        String dest1 = "hello2.txt";
        System.out.println(IOUtil.copyFile(src1, dest1));

        String src2 = "Process.png";
        String dest2 = "Process3.png";
        System.out.println(IOUtil.copyFile(src2, dest2));
    }


    /*
        Input/OutputStream主要用来处理非文本文件，读取文件时使用byte型数组。由于一个字符可能由多个字节组成，使用
        这两个流读取文件可能会导致文件乱码
     */
    @Test
    public void testFileInputOutput() {
        // Create File objects.
        File srcFile = new File("Process.png");
        File destFile = new File("Process2.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Create stream objects.
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // Read by using input stream, write by using output stream.
            byte[] bytes = new byte[5];
            int len;
            while((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close stream.
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
