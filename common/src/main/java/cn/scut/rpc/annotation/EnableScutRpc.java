package cn.scut.rpc.annotation;

import cn.scut.rpc.config.ScutRpcScannerRegistrar;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wanghy
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableDiscoveryClient
@Import(ScutRpcScannerRegistrar.class)
public @interface EnableScutRpc {
    String serverBasePackage() default "";
}
