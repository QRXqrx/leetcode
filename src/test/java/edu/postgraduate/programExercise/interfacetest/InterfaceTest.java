package edu.postgraduate.programExercise.interfacetest;

import edu.postgraduate.programExercise.interfacetest.example.proxy.Network;
import edu.postgraduate.programExercise.interfacetest.example.proxy.ProxyServer;
import edu.postgraduate.programExercise.interfacetest.example.proxy.Server;
import org.junit.Test;

public class InterfaceTest {
    @Test
    public void testProxy() {
        // 1.需要被访问的服务器
//        Server server = new Server();
        Network server = new Server();
        // 2.服务器代理
        ProxyServer proxy = new ProxyServer(server);
//        Network proxy = new ProxyServer(server); 也可
        // 3.代理访问
        proxy.browse();
    }
}
