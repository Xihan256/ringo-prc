package cn.scut.rpc.impl;

import cn.scut.rpc.annotation.RpcService;
import cn.scut.rpc.service.SampleService;

/**
 * @author wanghy
 */
@RpcService
public class SampleServiceImpl implements SampleService {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
