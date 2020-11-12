package cn.cps.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/12 15:26
 * @Description: 自定义负载均衡策略
 */
@Configuration
public class MyRule {

    @Bean
    public IRule myRandomRule(){
        return new RandomRule();
    }

}
