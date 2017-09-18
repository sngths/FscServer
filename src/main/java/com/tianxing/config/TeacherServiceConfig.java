package com.tianxing.config;

import com.tianxing.webapi.AssignmentController;
import com.tianxing.webapi.FileUploadController;
import com.tianxing.webapi.FileDownloadController;
import com.tianxing.webapi.TestController;
import com.tianxing.data.assignment.AssignmentPool;
import com.tianxing.data.account.AccountManager;
import com.tianxing.data.session.SessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianxing on 16/9/7.
 *
 */
@Configuration
@ComponentScan(basePackageClasses = {TestController.class, FileUploadController.class, AssignmentController.class, FileDownloadController.class})
public class TeacherServiceConfig {



    @Bean
    public AssignmentPool assignmentPool(){
        return new AssignmentPool();
    }


    @Bean
    public AccountManager accountManager(){
        return new AccountManager();
    }


    @Bean
    public SessionManager sessionManager(){
        return new SessionManager();
    }


}
