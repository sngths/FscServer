package config;

import controller.AssignmentController;
import controller.FileUploadController;
import controller.FileDownloadController;
import controller.TestController;
import data.AssignmentPool;
import data.account.AccountManager;
import data.session.SessionManager;
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
