package com.justin.sportsmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 新闻服务
 * @author chenjianting
 * @date 2019/07/16 14:41
 */
@SpringBootApplication
@EnableEurekaClient
public class NewsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsServiceApplication.class, args);
    }

}
