package edu.postgraduate.programExercise.interfacetest.example.proxy;

/**
 * 被代理类Server
 */
public class Server implements Network{
    @Override
    public void browse() {
        System.out.println("Server: 这个真实的服务器将被访问！");
    }
}
