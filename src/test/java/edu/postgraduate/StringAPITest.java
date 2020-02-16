package edu.postgraduate;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-14
 */
public class StringAPITest {

    // String -> bytes:编码，String.getBytes
    @Test
    public void test0() throws UnsupportedEncodingException {
        String str = "qrxLove萱萱";
        byte[] bytes1 = str.getBytes(); // 以默认字符集编码（编译器设置的UTF-8，一个汉字三个字节）
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = str.getBytes("gbk"); // 指定字符集编码（gbk编码，一个汉字两个字节）
        System.out.println(Arrays.toString(bytes2));

        System.out.println("****************************************");

        String str1 = new String(bytes1); // 用默认字符集解码
        System.out.println(str1);

        String str2 = new String(bytes2); // 用默认字符集解码。编码集和解码集不一致，导致乱码。
        System.out.println(str2);

        String str3 = new String(bytes2, "gbk"); // 采用指定字符集解码。编码集和解码集一致，正常输出。
        System.out.println(str3);
    }
}
