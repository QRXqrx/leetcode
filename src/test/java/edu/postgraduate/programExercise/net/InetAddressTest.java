package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * InetAddress对象表示了单个IP地址。该类的构造器被私有化，想要获取实例化的对象必须通过
 * 类中封装的方法
 *
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class InetAddressTest {

    @Test
    public void testGetByName() {
        try {
            // 通过ip地址访问
            InetAddress inet1 = InetAddress.getByName("192.168.7.13");
            System.out.println(inet1);

            // 通过域名访问。因为要走DNS服务器所以会比较慢
            InetAddress inet2 = InetAddress.getByName("www.mooctest.net");
            System.out.println(inet2);

            // 访问本地的几种方法
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");
            InetAddress inet4 = InetAddress.getLocalHost();
            InetAddress inet5 = InetAddress.getByName("localhost");
            System.out.println(inet3);
            System.out.println(inet4);
            System.out.println(inet5);

            // InetAddress的两个成员方法。根据这个可以判断出InetAddress的toString方法是这两个 + /
            System.out.println("---------------------------------------");
            System.out.println(inet2.getHostAddress());
            System.out.println(inet2.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
