package com.atguigu.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
//        return  new RoundRobinRule();//轮询,默认
        return new RandomRule();//使用随机算法替换默认的轮询算法
//        return new AvailabilityFilteringRule();//会过滤掉由于访问故障而处于断路器跳闸状态的服务和并发数量超过阈值的服务
    }

}
