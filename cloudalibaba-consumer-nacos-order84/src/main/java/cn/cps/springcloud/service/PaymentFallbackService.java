package cn.cps.springcloud.service;

import cn.cps.springcloud.entities.CommonResult;
import cn.cps.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: Cai Peishen
 * @Date: 2020/12/16 09:18
 * @Description:
 */
@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
