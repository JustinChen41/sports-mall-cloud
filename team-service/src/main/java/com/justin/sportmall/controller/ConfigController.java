package com.justin.sportmall.controller;

import com.justin.sportmall.service.NewsServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: chenjianting
 * @Date: 2019/7/23 15:02
 */
@RestController
@RequestMapping(value = "/team")
public class ConfigController {
    @Value("${open-team}")
    private boolean openTeam;

    @Autowired
    private NewsServiceApi newsServiceApi;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/config")
    public boolean getTeam() {
        return openTeam;
    }

    @RequestMapping(value = "/feign")
    public String feignTest() {
        return newsServiceApi.getNewsConfig();
    }

    @RequestMapping(value = "/ribbon")
    public String ribbonTest() {
        return restTemplate.getForObject("http://news/config", String.class);
    }
}
