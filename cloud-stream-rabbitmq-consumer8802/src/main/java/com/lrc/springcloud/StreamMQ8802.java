package com.lrc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author luo
 * @date 2021/8/14 22:31
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQ8802 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQ8802.class, args);
    }

}
