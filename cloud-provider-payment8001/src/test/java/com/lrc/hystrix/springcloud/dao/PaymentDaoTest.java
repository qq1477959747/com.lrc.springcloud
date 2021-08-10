package com.lrc.hystrix.springcloud.dao;

import com.lrc.hystrix.springcloud.entities.Payment;
import com.lrc.hystrix.springcloud.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author luo
 * @date 2021/8/3 21:16
 */
class PaymentDaoTest {

    @Autowired
    PaymentService paymentService;

    @Test
     void create() {

        Payment payment = new Payment();
        payment.setSerial("哈哈哈哈");
        paymentService.create(payment);

    }
}
