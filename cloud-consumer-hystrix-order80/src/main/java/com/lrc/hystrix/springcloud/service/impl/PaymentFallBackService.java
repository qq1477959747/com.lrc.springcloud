package com.lrc.hystrix.springcloud.service.impl;

import com.lrc.hystrix.springcloud.entities.CommonResult;
import com.lrc.hystrix.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author luo
 * @date 2021/8/8 20:16
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService {
    @Override
    public CommonResult getPaymentById(Long id) {
        return null;
    }

    @Override
    public String paymentFeignTimeout() {
        return "paymentFeignTimeout-----fallback";
    }

    @Override
    public String paymentHystrixTimeout(Long id) {
        return "getPaymentById------fallback";
    }

    @Override
    public String paymentHystrixOK(Long id) {
        return "paymentHystrixOK-----fallback";
    }
}
