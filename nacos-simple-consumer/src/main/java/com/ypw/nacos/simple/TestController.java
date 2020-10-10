package com.ypw.nacos.simple;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yupengwu
 */
@RestController
@NacosConfigurationProperties(dataId = "nacos-simple-consumer-config", autoRefreshed = true)
public class TestController {
    @Value("${echoParam:123}")
    String echoParam;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        return restTemplate.getForObject("http://nacos-simple-producer/echo/", String.class);
    }

    @GetMapping("/echo")
    public String echo() {
        System.out.println(echoParam);
        return echoParam;
    }

}
