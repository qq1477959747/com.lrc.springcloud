package com.lrc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author luo
 * @date 2021/8/11 21:09
 */
@SpringBootApplication
@EnableEurekaClient
public class Config3355 {

    public static void main(String[] args) {
        SpringApplication.run(Config3355.class, args);
    }

}
