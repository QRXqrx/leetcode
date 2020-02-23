package edu.postgraduate.programExercise.net;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author QRX
 * @email QRXwzx@outlook.com
 * @date 2020-02-23
 *
 * https://space.bilibili.com/270340679/favlist?fid=494174879&ftype=create
 */
public class URLTest {

    @Test
    public void testURL() {
        try {
            URL url = new URL("https://space.bilibili.com/270340679/favlist?fid=494174879&ftype=create");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
