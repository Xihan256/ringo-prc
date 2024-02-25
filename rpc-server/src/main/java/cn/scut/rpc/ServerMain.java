package cn.scut.rpc;

import cn.scut.rpc.annotation.EnableScutRpc;
import cn.scut.rpc.network.RpcBootStrapFactory;
import cn.scut.rpc.network.RpcServerBootStrap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author wanghy
 */
@SpringBootApplication
@EnableScutRpc(serverBasePackage = "cn.scut.rpc.impl")
public class ServerMain {

    @Value("${scut-rpc.server-port}")
    private Integer serverPort;

    public static void main(String[] args) {
        SpringApplication.run(ServerMain.class, args);
    }

    /**
     * server 必须要这个bean, 用来初始化网络
     * @return RpcServerBootStrap
     */
    @Bean
    public RpcServerBootStrap rpcServerBootStrap(){
        return RpcBootStrapFactory.getServerBootStrapInstance(serverPort);
    }
}