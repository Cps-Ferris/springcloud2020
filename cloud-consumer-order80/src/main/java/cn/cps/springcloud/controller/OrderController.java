package cn.cps.springcloud.controller;

import cn.cps.springcloud.entities.CommonResult;
import cn.cps.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/3 18:32
 * @Description:
 */
@Slf4j
@RestController
public class OrderController
{
    // 单机
    // public static final String PAYMENT_URL = "http://localhost:8001";

    // 集群时，需要指明一种负载均衡策略，不然多个服务，不知道调用哪一个 -> 在RestTemplate配置上添加@LoadBalanced
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }


}
