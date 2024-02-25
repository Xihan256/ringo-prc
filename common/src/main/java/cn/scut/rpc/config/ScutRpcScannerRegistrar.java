package cn.scut.rpc.config;

import cn.scut.rpc.annotation.EnableScutRpc;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;

/**
 * @author wanghy
 * 配置自定义扫包, 效果类似于MyBatis的@MapperScan
 * 扫包时,所有@RpcService的都会扫进去创一个bean
 */
public class ScutRpcScannerRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(@NonNull AnnotationMetadata importingClassMetadata, @NonNull BeanDefinitionRegistry registry) {
        //主类上有@EnableScutRpc才触发扫包
        String basePackage = (String) importingClassMetadata.
                getAnnotationAttributes(EnableScutRpc.class.getName()).get("serverBasePackage");

        RpcPackageScanner scanner = new RpcPackageScanner();
        //真正扫包的逻辑
        try {
            scanner.scan(basePackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
