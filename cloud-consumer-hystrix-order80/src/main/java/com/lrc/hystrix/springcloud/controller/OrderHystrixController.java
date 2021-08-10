package com.lrc.hystrix.springcloud.controller;

import com.lrc.hystrix.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luo
 * @date 2021/8/6 22:35
 */
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentHystrixOK(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentHystrixOK(id);
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentHystrixTimeOutFallback", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentHystrixTimeOut(@PathVariable("id") Long id) {
        return paymentHystrixService.paymentHystrixTimeout(id);
    }

    public String paymentHystrixTimeOutFallback(@PathVariable("id") Long id) {
        return "Hystrix 消费者80，对方支付系统业务繁忙，请稍候";
    }

    /**
     * 全部 fallback（服务降级） 方法
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Gloabl 异常处理信息，请稍后再试！";
    }

}
