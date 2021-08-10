package com.lrc.hystrix.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.lrc.hystrix.springcloud.dao.PaymentDao;
import com.lrc.hystrix.springcloud.entities.Payment;
import com.lrc.hystrix.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @USER luo
 * @Date 2021/7/30 22:51
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public Payment updateById(Payment payment) {
        if (null != payment.getId()) {
            Payment oldPayment = this.getPaymentById(payment.getId());
            if (null != oldPayment) {
                paymentDao.updateById(payment);
                return payment;
            }
        }
        return null;
    }

    @Override
    public String paymentInfoOK(Long id) {
        return String.format("线程池：%s  paymentInfo_OK,id： %s\tO(∩_∩)O哈哈~",
                Thread.currentThread(), Thread.currentThread().getId());
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @Override
    public String paymentInfoTimeOut(Long id) {
        try {
            TimeUnit.SECONDS.sleep(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("线程池：%s  paymentInfoTimeOut,id： %s\tO(∩_∩)O哈哈~  耗时(秒) %s s",
                Thread.currentThread(), Thread.currentThread().getId(), id);
    }

    /**
     * 服务熔断案例
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            // 在时间窗口期内，10次访问失败率达到60%跳闸
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到 多少 熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName() + "\t" + "调用成功，支付流水号为：" + serialNumber;
    }

    @Override
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Long id) {
        return "*****id 不能为负数：" + id;
    }

    public String paymentInfo_TimeOutHandle(Long id) {
        return String.format("线程池：%s  paymentInfo_TimeOutHandle,id： %s\t/(ㄒoㄒ)/~~哈哈~  耗时(秒) %s s",
                Thread.currentThread(), Thread.currentThread().getId(), id);
    }


}
