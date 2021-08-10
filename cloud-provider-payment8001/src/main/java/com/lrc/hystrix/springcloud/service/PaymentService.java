package com.lrc.hystrix.springcloud.service;

import com.lrc.hystrix.springcloud.entities.Payment;

/**
 * @USER luo
 * @Date 2021/7/30 22:51
 */
public interface PaymentService {


    int create(Payment payment);

    Payment getPaymentById(Long id);

    Payment updateById(Payment payment);

}
