package com.xiaoyang.consumer.controller;

import com.xiaoyang.consumer.clients.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaoyang.wen
 * @date 2019/3/1 11:46
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    private final RestTemplate restTemplate;
    private final IProviderService providerService;

    @Autowired
    public ConsumerController(RestTemplate restTemplate, IProviderService providerService) {
        this.restTemplate = restTemplate;
        this.providerService = providerService;
    }

    @GetMapping("/name/rest/{id}")
    public String restGetName(@PathVariable("id") String id) {
        return restTemplate.getForObject("http://service-provider/provider/id/" + id, String.class);
    }
    @GetMapping("/name/feign/{id}")
    public String feignGetName(@PathVariable("id") String id) {
        return providerService.getNameById(id);
    }
}
