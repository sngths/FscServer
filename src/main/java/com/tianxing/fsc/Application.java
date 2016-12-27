package com.tianxing.fsc;

import com.tianxing.config.DataBaseConfig;
import com.tianxing.config.TeacherServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by tianxing on 16/8/29.
 *
 */
@SpringBootApplication
@Import({TeacherServiceConfig.class, DataBaseConfig.class})

public class Application extends SpringBootServletInitializer{





    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return super.configure(builder);
    }

    public static void main(String[] args){
        ApplicationContext app = SpringApplication.run(Application.class, args);




    }
}
