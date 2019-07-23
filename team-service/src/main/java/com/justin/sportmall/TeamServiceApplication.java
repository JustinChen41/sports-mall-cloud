package com.justin.sportmall;

import com.justin.ribbon.RibbonConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenjianting
 */
@SpringBootApplication(scanBasePackages = "com.justin.sportmall")
@EnableEurekaClient
@EnableFeignClients
@RibbonClient(name = "team", configuration = RibbonConfigure.class)
//@RibbonClients(defaultConfiguration = {RibbonConfigure.class})
public class TeamServiceApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(TeamServiceApplication.class, args);
    }

}
