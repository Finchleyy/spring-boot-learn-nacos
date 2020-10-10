package com.ypw.nacos.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yupengwu
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSimpleProducerApplication {


    public static void main(String[] args) {
        SpringApplication.run(NacosSimpleProducerApplication.class, args);
    }

    @RestController
    public static class EchoTest {

        @GetMapping("/echo")
        public String echo() {
            return "NacosSimpleProducerApplication\n";
        }

    }
}
