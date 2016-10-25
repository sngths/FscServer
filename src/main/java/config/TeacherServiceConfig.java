package config;

import controller.AssignmentController;
import controller.FileUploadController;
import controller.FileDownloadController;
import controller.TestController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianxing on 16/9/7.
 *
 */
@Configuration
@ComponentScan(basePackageClasses = {TestController.class, FileUploadController.class, AssignmentController.class, FileDownloadController.class})
public class TeacherServiceConfig {

}
