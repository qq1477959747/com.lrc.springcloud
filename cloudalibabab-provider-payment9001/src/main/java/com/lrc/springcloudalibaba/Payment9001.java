package com.lrc.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author luo
 * @date 2021/8/16 22:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9001 {

    public static void main(String[] args) {
        SpringApplication.run(Payment9001.class, args);
    }

}
