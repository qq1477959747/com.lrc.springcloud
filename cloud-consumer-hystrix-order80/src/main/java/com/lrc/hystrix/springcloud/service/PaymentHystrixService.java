package com.lrc.hystrix.springcloud.service;

import com.lrc.hystrix.springcloud.entities.CommonResult;
import com.lrc.hystrix.springcloud.service.impl.PaymentFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author luo
 * @date 2021/8/6 22:31
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallBackService.class)
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String paymentFeignTimeout();

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentHystrixTimeout(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentHystrixOK(@PathVariable("id") Long id);

}
