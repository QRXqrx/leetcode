package edu.postgraduate.programExercise.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-22
 */
public class IOUtil {

    private IOUtil() {
    }

    public static String encryptOrDecryptFile(String src, String dest) {

        File destFile = new File(dest);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(destFile);

            byte[] bytes = new byte[5];
            int len;
            while((len = fis.read(bytes) ) != -1) {
                for(int i = 0 ; i < len ; i++) {
                    bytes[i] = (byte) (bytes[i] ^ 5);
                }
                fos.write(bytes, 0 , len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return destFile.getAbsolutePath();
    }

    public static String copyFile(String src, String dest) {
        File srcFile = new File(src);
        File destFile = new File(dest);

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

        return destFile.getAbsolutePath();
    }
}
