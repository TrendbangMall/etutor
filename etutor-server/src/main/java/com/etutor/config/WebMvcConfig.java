package com.etutor.config;

import com.etutor.intercepter.LoginCheckInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author winter
 * @version 1.0
 * @date 2020/4/14 10:21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(accessLoginCheckInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger**", "/webjars/springfox-swagger-ui/**");
//        registry.addInterceptor(accessLoginCheckInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/webjars/bootstrap/**");

        // ResourceHttpRequestHandler ["classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/", "/"]
    }

    @Bean
    public LoginCheckInterceptor accessLoginCheckInterceptor() {
        return new LoginCheckInterceptor();
    }

}
