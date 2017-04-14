package com.tianxing.config;

import com.tianxing.controller.AccountService;
import com.tianxing.controller.AssignmentService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tianxing on 2017/4/11.
 *
 */
@Configuration
@ComponentScan(basePackageClasses = {AccountService.class, AssignmentService.class})
public class FscConfig {

}
