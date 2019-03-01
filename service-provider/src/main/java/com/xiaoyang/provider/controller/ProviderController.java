package com.xiaoyang.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaoyang.wen
 * @date 2019/2/28 17:24
 */
@RefreshScope
@RestController
@RequestMapping("/provider")
public class ProviderController {

    private static Map<String, String> nameMap;

    @Value("${name}")
    String name;

    @PostConstruct
    public void initMap() {
        nameMap = new HashMap<>(4);
        nameMap.put("1", "name1");
        nameMap.put("2", "name2");
        nameMap.put("3", "name3");
        nameMap.put("4", "name4");
    }

    @GetMapping("/id/{id}")
    public String getNameById(@PathVariable("id") String id) {
        if (!"".equals(id)) {
            return nameMap.get(id);
        }
        return null;
    }
    @GetMapping("/config")
    public String config(){
        return name;
    }

}
