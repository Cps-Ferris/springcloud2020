package cn.cps.springcloud.controller;

import cn.cps.springcloud.entities.CommonResult;
import cn.cps.springcloud.entities.Payment;
import cn.cps.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/10 14:24
 * @Description:
 */
@Slf4j
@RestController
public class PaymentController
{

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);

        if(result > 0)
        {
            return new CommonResult(200,"插入数据库成功,serverPort: "+serverPort,result);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);

        if(payment != null){
            return new CommonResult(200,"查询成功,serverPort:  "+serverPort,payment);
        }else{
            return new CommonResult(444,"没有对应记录,查询ID: "+id,null);
        }
    }

    @GetMapping("/payment/discover")
    public void discover() {
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            log.info("服务名："+s);
            List<ServiceInstance> instances = discoveryClient.getInstances(s);
            for(ServiceInstance instance : instances){
                log.info("实例名："+instance.getInstanceId()+"\tIP："+instance.getHost()+"\t端口："+instance.getPort()+"\tURL："+instance.getUri());
            }
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB()
    {
        return serverPort;
    }


    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

}
