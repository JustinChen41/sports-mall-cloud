package com.justin.sportsmall.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: chenjianting
 * @Date: 2019/7/16 17:40
 */
@RestController
public class TestController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${hello}")
    private String hello;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/config")
    public String getConfig() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("news");
        logger.info("{}: {}:{}:{}", System.currentTimeMillis(), serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return hello;
    }
}
