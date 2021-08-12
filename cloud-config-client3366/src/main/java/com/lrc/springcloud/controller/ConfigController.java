package com.lrc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luo
 * @date 2021/8/12 21:46
 */
@RestController
@RefreshScope
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @Value(("${server.port}"))
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return serverPort + " : " + configInfo;
    }
}
