package cn.cps.springcloud.service.impl;

import cn.cps.springcloud.entities.Payment;
import cn.cps.springcloud.dao.PaymentDao;
import cn.cps.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Cai Peishen
 * @Date: 2020/11/10 14:24
 * @Description:
 */
@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
