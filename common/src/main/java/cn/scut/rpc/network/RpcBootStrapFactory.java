package cn.scut.rpc.network;

/**
 * @author wanghy
 */
public class RpcBootStrapFactory {
    public static RpcServerBootStrap getServerBootStrapInstance(Integer port){
        RpcServerBootStrap serverBootStrap = new RpcServerBootStrap();
        serverBootStrap.init(port);
        return serverBootStrap;
    }
}
