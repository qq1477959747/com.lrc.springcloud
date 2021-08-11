package com.lrc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author luo
 * @date 2021/8/11 20:43
 */
@SpringBootApplication
@EnableConfigServer
public class Config3344 {

    public static void main(String[] args) {
        SpringApplication.run(Config3344.class, args);
    }

}
