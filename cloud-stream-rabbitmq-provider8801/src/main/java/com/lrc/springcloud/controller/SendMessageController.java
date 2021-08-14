package com.lrc.springcloud.controller;

import com.lrc.springcloud.service.MessageProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luo
 * @date 2021/8/14 22:13
 */
@RestController
public class SendMessageController {

    @Autowired
    MessageProvide messageProvide;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return messageProvide.send();
    }

}
