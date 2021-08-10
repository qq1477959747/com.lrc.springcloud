package com.lrc.hystrix.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderFeignOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignOrder80.class, args);
    }

}
