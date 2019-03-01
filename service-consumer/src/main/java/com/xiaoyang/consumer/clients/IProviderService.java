package com.xiaoyang.consumer.clients;

import com.xiaoyang.consumer.clients.fallback.ProviderServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xiaoyang.wen
 * @date 2019/3/1 13:50
 */
@Repository
@FeignClient(name = "service-provider",fallback = ProviderServiceFallBack.class)
public interface IProviderService {

    @RequestMapping(value = "/provider/id/{id}", method = RequestMethod.GET)
    String getNameById(@PathVariable("id") String id);

}

