package edu.postgraduate.programExercise.io;

import edu.postgraduate.programExercise.bean.Dog;
import org.junit.Test;

import java.io.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class ObjectStreamTest {


    /*
        反序列化
        将序列化的对象按照写入顺序读入程序，可以进行展示或者网络传输等后续操作
     */
    @Test
    public void testOutputInputStream() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("serial.dat"));
            String str = (String) ois.readObject();
            Dog dog = (Dog) ois.readObject();

            System.out.println(str);
            System.out.println(dog);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
        序列化
        将对象序列化后写出到文件，持久化到物理内存
     */
    @Test
    public void testObjectOutputStream() {
        File dataFile = new File("serial.dat");
        ObjectOutputStream oos = null; // 对象流是处理流的一种，需要建立在节点流的基础之上
        try {
            FileOutputStream fos = new FileOutputStream(dataFile); // 建立节点流
            oos = new ObjectOutputStream(fos);
//        oos.writeInt(); // 也可以write基本数据，其实也属于数据流的一种
            oos.writeObject(new String("对象的序列化"));
            oos.writeObject(new Dog("逗逗", 5));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(oos != null) {
                try {
                    oos.close(); // 关闭外层流，连带着关闭内部流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
