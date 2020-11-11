package cn.cps.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/11 16:20
 * @Description: zookeeper消费端
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMainZk80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMainZk80.class, args);
    }

}
