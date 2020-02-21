package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.File;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-19
 */
public class FileTest {

    @Test
    public void test0() {
        File file1 = new File("hello.txt");
        File file2 = new File("hi.txt");

        System.out.println(file1.renameTo(file2));
    }
}
