package edu.postgraduate.programExercise.interfacetest.example.proxy;

public class ProxyServer implements Network {

    Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    private void check() {
        System.out.println("ProxyServer: 服务器代理将为用户完成连接服务器之前的检查！");
    }

    @Override
    public void browse() {
        check();
        // 调用被代理者
        network.browse();
    }
}
