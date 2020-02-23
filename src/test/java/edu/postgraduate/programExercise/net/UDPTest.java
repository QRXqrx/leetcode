package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-23
 */
public class UDPTest {

    @Test
    public void testSender() {
        try (DatagramSocket socket = new DatagramSocket()) {

            String str = "我是UDP方式发送的信息！";
            byte[] data = str.getBytes();
            InetAddress inet = InetAddress.getLocalHost();
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 8899);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testReceiver() {
        try (DatagramSocket socket = new DatagramSocket(8899)) {

            byte[] data = new byte[100];
            DatagramPacket packet = new DatagramPacket(data, 0, data.length);

            socket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength()));

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
