package edu.postgraduate.programExercise.io;

import org.junit.Test;

import java.io.*;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class BufferedTest {

    @Test
    public void testEncryption() { // 加密传输测试
        String src = "Git指令.txt";
        String mid = "Git指令Encry.txt";
        String dest = "Git指令2.txt";
        System.out.println(IOUtil.encryptOrDecryptFile(src, mid));
        System.out.println(IOUtil.encryptOrDecryptFile(mid, dest));
    }

    @Test
    public void testBufferedTXTCopy() {
        String src = "Git指令.txt";
        String dest = "Git指令1.txt";
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            // 将1、2两步合并
            br = new BufferedReader(new FileReader(new File(src)));
            bw = new BufferedWriter(new FileWriter(new File(dest))); // 以覆盖方式构造writer

            // 使用readLine进行读写
            String line;
            while((line = br.readLine()) != null) {
                bw.write(line); // 从文件中读取一行，不包括换行符
                // bw.write(line + "\n"); 自行换行，有点憨
                bw.newLine(); // 使用BufferedWriter提供的换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 资源关闭
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testBufferedCopy() {
        File srcFile = new File("Process.png");
        File destFile = new File("Process4.png");

        // 2.1在文件对象的基础上构建节点流
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            // 2.2在节点流的基础上构建处理流之一的缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 使用同样的步骤进行读写，缓冲流的特点是读写效率更高。
            byte[] bytes = new byte[10];
            int len;
            while((len = bis.read()) != -1) {
                bos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.1关闭流的操作应该从外到里进行。先关闭外部的缓冲流，后关闭的内部的节点流
            if(bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            /*
                4.2缓冲流中封装了内部流的关闭操作，在关闭缓冲流时内部节点流会同时关闭，因此可以省略
                fos.close();
                fis.close();
            */
        }


    }
}
