package com.justin.sportmall.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: chenjianting
 * @Date: 2019/7/23 15:17
 */
@Service
@FeignClient(name = "news")
public interface NewsServiceApi {
    /**
     * 请求news-service获取配置
     * @return
     */
    @RequestMapping(value = "/config")
    String getNewsConfig();
}
