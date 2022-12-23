package com.lzy.platform.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName RibbonConfig
 * @Description Ribbon公共负载均衡策略配置
 * @Author LiZuoYang
 * @Date 2022/6/14 10:29
 **/
@Configuration
public class RibbonConfig {
    @Bean
    public IRule iRule() {
        // 随机策略
        return new RandomRule();
    }
}
