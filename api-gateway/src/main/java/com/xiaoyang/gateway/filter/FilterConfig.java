package com.xiaoyang.gateway.filter;

import com.xiaoyang.gateway.filter.TestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author xiaoyang.wen
 * @date 2019/3/6 15:52
 */
@Component
public class FilterConfig {

    @Bean
    TestFilter initTestFilter(){
        return new TestFilter();
    }


}
