package com.lrc.hystrix.springcloud.controller;

import com.lrc.hystrix.springcloud.entities.CommonResult;
import com.lrc.hystrix.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author luo
 * @date 2021/8/3 22:21
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        String url = String.format(PAYMENT_URL + "/payment/get/%s",id);
        return restTemplate.getForObject(url,CommonResult.class);
    }

    @GetMapping("/consumer/payment/update")
    public CommonResult<Payment> update(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/update",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/zipkin")
    public String paymentZipkin() {
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/zipkin/",String.class);
        return result;
    }


}
