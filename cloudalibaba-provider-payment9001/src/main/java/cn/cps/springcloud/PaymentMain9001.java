package cn.cps.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: Cai Peishen
 * @Date: 2020/12/3 16:18
 * @Description: Nacos服务提供者
 */
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentMain9001
{
    public static void main(String[] args) {
            SpringApplication.run(PaymentMain9001.class, args);
    }
}
