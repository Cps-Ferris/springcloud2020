package cn.cps.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/3 18:33
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // 使用自定义负载轮询 不开启注解型的LoadBalanced
    //@LoadBalanced // 当为集群时，必须要启用负载均衡策略，不然多个服务不知道调用哪一个
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
