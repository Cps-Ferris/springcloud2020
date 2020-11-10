package cn.cps.springcloud.service;

import cn.cps.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/10 14:24
 * @Description:
 */
public interface PaymentService
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
