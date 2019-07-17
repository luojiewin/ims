package com.roger.ims.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  
* @Title: WebMvcConfig  
* @Description: swagger配置文件
* @author roger  
* @date 2019年7月17日  
*/  
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("classpath:/static/")
				.excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");

		WebMvcConfigurer.super.addInterceptors(registry);

	}
}
