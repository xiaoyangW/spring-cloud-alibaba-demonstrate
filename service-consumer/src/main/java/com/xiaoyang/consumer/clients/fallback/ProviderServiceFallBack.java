package com.xiaoyang.consumer.clients.fallback;

import com.xiaoyang.consumer.clients.IProviderService;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyang.wen
 * @date 2019/3/1 13:53
 */
public class ProviderServiceFallBack implements IProviderService {
    @Override
    public String getNameById(String id) {
        return "getNameById fallback";
    }
}
