package cn.scut.rpc.proxy;

/**
 * @author wanghy
 * 代理了RPC服务的类
 */
public class ServiceBean<T> {
    private T service;
    private String serviceClassName;

    private String serviceName;

    private ServiceBean(T service, String serviceClassName, String serviceName) {
        this.service = service;
        this.serviceClassName = serviceClassName;
        this.serviceName = serviceName;
    }

    protected static <A> ServiceBean<A> createBean(A service, String serviceClassName, String serviceName){
        return new ServiceBean<>(service, serviceClassName, serviceName);
    }

    public Object getService() {
        return service;
    }

    public String getServiceClassName() {
        return serviceClassName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
