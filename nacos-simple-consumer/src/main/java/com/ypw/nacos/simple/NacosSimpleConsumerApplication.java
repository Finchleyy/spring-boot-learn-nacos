package com.ypw.nacos.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yupengwu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSimpleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSimpleConsumerApplication.class, args);
    }

    @RestController
    public static class EchoTest {

        @GetMapping("/")
        public String echo() {
            return "NacosSimpleConsumerApplication";
        }

    }
}
