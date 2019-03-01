package com.xiaoyang.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author xiaoyang.wen
 * @date 2019/3/1 11:46
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    private final RestTemplate restTemplate;

    @Autowired
    public ConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/name/{id}")
    public String getName(@PathVariable("id") String id) {
        return restTemplate.getForObject("http://service-provider/provider/id/" + id, String.class);
    }

}
