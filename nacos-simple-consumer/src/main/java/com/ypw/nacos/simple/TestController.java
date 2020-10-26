package com.ypw.nacos.simple;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yupengwu
 */
@RestController
@NacosConfigurationProperties(
        groupId = "DEFAULT_GROUP",
        type = ConfigType.PROPERTIES,
        dataId = "test",
        autoRefreshed = true)
public class TestController {
    @Value(value = "${echoParam:123}")
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
