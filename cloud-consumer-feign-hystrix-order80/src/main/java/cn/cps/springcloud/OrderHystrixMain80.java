package cn.cps.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/19 16:36
 * @Description: Hystrix熔断器
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class OrderHystrixMain80
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
