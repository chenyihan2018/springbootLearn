package com.jslx.config;/**
 * Created by chenjia on 2018/5/30.
 */

import com.jslx.interceptor.InterceptorConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author chenjia
 * @create 2018-05-30 11:03
 * @desc
 **/
@Configuration
@EnableWebMvc
@ComponentScan
public class WebAppConfig extends WebMvcConfigurerAdapter {

    public static String SESSION_KEY = "learnboot_session_key";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**").excludePathPatterns("/static/**").excludePathPatterns("/error");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
