package com.lrc.hystrix.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author luo
 * @date 2021/8/8 22:38
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class, args);
    }

}
