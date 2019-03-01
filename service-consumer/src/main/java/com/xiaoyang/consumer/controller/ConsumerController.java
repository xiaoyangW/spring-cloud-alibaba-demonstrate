package com.xiaoyang.consumer.controller;

import com.xiaoyang.consumer.clients.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
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
    private final DiscoveryClient discoveryClient;
    @Autowired
    public ConsumerController(RestTemplate restTemplate, IProviderService providerService, DiscoveryClient discoveryClient) {
        this.restTemplate = restTemplate;
        this.providerService = providerService;
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/name/rest/{id}")
    public String restGetName(@PathVariable("id") String id) {
        return restTemplate.getForObject("http://service-provider/provider/id/" + id, String.class);
    }
    @GetMapping("/name/feign/{id}")
    public String feignGetName(@PathVariable("id") String id) {
        return providerService.getNameById(id);
    }

    @RequestMapping(value = "/services/{service}", method = RequestMethod.GET)
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public Object services() {
        return discoveryClient.getServices();
    }
}
