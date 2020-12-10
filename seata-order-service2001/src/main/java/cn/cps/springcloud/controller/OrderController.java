package cn.cps.springcloud.controller;

import cn.cps.springcloud.domain.CommonResult;
import cn.cps.springcloud.domain.Order;
import cn.cps.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Cai Peishen
 * @Date: 2020/12/10 15:18
 * @Description:
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
