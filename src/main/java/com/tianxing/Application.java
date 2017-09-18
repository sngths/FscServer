package com.tianxing;

import com.tianxing.config.DataBaseConfig;
import com.tianxing.config.FscConfig;
import com.tianxing.config.TeacherServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

/**
 * Created by tianxing on 16/8/29.
 *
 *
 */

@EnableEurekaServer
@SpringBootApplication
@Controller
@Import({TeacherServiceConfig.class, DataBaseConfig.class, FscConfig.class})
public class Application extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return super.configure(builder);
    }

    public static void main(String[] args){
        ApplicationContext app = SpringApplication.run(Application.class, args);
    }
}
