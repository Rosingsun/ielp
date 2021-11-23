package com.mudongheng.ielp.security.config;

import com.mudongheng.ielp.security.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 幕冬
 * @since 2021年10月27日
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TokenFilter> tokenFilter() {
        FilterRegistrationBean<TokenFilter> frBean = new FilterRegistrationBean<>();
        frBean.setFilter(new TokenFilter());
        frBean.addUrlPatterns("/*");
        return frBean;
    }

}
