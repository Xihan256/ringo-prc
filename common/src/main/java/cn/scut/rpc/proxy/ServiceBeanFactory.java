package cn.scut.rpc.proxy;

/**
 * @author wanghy
 */
public class ServiceBeanFactory {
    public static <T> void addService(T service, String serviceClassName, String serviceName){
        ServiceBean<T> bean = ServiceBean.createBean(service, serviceClassName, serviceName);
        ServiceBeans.beanRegistry(serviceName, bean);
    }
}
