package com.example.demo;


import java.util.Properties;

import org.hibernate.Interceptor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
@Controller
@EnableCaching
public class DemoApplication extends SpringBootServletInitializer {
    @RequestMapping("/")
	String home() {
		return "/login.jsp";
	}

        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
            return builder.sources(DemoApplication.class);
        }
      /*  @Bean
        PageHelper pageHelper(){
            //分页插件
            PageHelper pageHelper = new PageHelper();
            Properties properties = new Properties();
            properties.setProperty("reasonable", "true");
            properties.setProperty("supportMethodsArguments", "true");
            properties.setProperty("returnPageInfo", "check");
            properties.setProperty("params", "count=countSql");
            pageHelper.setProperties(properties);

            //添加插件
            new SqlSessionFactoryBean().setPlugins(new Interceptor[]{pageHelper});
            return pageHelper;
        }    */
}