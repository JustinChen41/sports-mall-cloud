package com.justin.sportsmall.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenjianting
 * @Date: 2019/7/16 17:40
 */
@RestController
public class TestController {

    @Value("${hello}")
    private String hello;

    @GetMapping(value = "/config")
    public String getConfig() {
        return hello;
    }
}
