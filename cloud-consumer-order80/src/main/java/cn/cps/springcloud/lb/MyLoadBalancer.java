package cn.cps.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/18 14:55
 * @Description: 自定义
 */
@Component
public class MyLoadBalancer implements LoadBalancer{

    // 原子操作类
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getNextNum(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current + 1;
        // 当前的值与内存中记录的值比较，如果相等则更新为最新的数据
        }while (!atomicInteger.compareAndSet(current, next));

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        if(serviceInstances == null || serviceInstances.size() == 0){
            return null;
        }

        // 遍历次数 % 实例数量 = 访问的索引
        int index = getNextNum() % serviceInstances.size();
        return serviceInstances.get(index);
    }

}
