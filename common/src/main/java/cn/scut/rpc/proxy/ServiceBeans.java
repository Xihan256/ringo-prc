package cn.scut.rpc.proxy;

import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wanghy
 */
public class ServiceBeans {
    /**
     * key是服务名, value是serviceBean
     */
    private static Map<String, ServiceBean<?>> serviceBeans = new HashMap<>();

    public static void beanRegistry(String serviceName, ServiceBean<?> serviceBean){
        serviceBeans.put(serviceName, serviceBean);
    }
}
