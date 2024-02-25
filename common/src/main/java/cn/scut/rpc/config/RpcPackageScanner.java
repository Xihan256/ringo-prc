package cn.scut.rpc.config;

import cn.scut.rpc.annotation.RpcService;
import cn.scut.rpc.proxy.ServiceBeanFactory;
import cn.scut.rpc.proxy.ServiceBeans;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

/**
 * @author wanghy
 */
public class RpcPackageScanner extends ClassPathScanningCandidateComponentProvider {

    public RpcPackageScanner() {
        super(false);
        addIncludeFilter(new AnnotationTypeFilter(RpcService.class));
    }

    public void scan(String basePackage) throws Exception {
        Set<BeanDefinition> candidateComponents = findCandidateComponents(basePackage);
        for (BeanDefinition candidateComponent : candidateComponents) {
            Class<?> clazz = Class.forName(candidateComponent.getBeanClassName());
            RpcService rpcServiceAnnotation = clazz.getAnnotation(RpcService.class);
            if (rpcServiceAnnotation != null) {
                String serviceName = rpcServiceAnnotation.value();
                Object instance = clazz.getConstructor().newInstance();
                String fullClassName = clazz.getName();
                if("".equals(serviceName)){
                    //表示没指定服务名,默认使用类名
                    ServiceBeanFactory.addService(instance, fullClassName, clazz.getSimpleName());
                }else{
                    ServiceBeanFactory.addService(instance, fullClassName, serviceName);
                }
            }
        }
    }
}
