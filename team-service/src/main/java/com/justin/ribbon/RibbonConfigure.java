package com.justin.ribbon;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon配置，如果application.yml也配置了ribbon信息，优先使用此类的配置
 * @Author: chenjianting
 * @Date: 2019/7/23 17:13
 */
@Configuration
public class RibbonConfigure {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
