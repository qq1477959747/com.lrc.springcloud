package com.lrc.hystrix.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author luo
 * @date 2021/8/8 12:28
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixOrder80.class, args);
    }

}
