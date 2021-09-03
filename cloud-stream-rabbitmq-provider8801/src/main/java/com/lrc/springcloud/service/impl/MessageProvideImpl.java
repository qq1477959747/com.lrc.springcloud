package com.lrc.springcloud.service.impl;

import com.lrc.springcloud.service.MessageProvide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author luo
 * @date 2021/8/14 21:37
 */
@EnableBinding(Source.class)
public class MessageProvideImpl implements MessageProvide {

    /**
     * 消息发送管道
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*******serial： " + serial);
        return null;
    }
}
