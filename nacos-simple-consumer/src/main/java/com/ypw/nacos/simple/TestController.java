package com.ypw.nacos.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yupengwu
 */
@RestController
//bootstrap.properties 中已经配置,这里不再生效
/*@NacosConfigurationProperties(
        groupId = "DEFAULT_GROUP",
        type = ConfigType.PROPERTIES,
        dataId = "nacos-simple-consumer-dev.properties",
        autoRefreshed = true)*/
@RefreshScope
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
