package cn.cps.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/3 16:18
 * @Description:
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentMain8001
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
