package com.tianxing.config;

import com.tianxing.controller.AccountController;
import com.tianxing.controller.AssignmentService;
import com.tianxing.controller.InfoController;
import com.tianxing.components.mediator.ComponentMediator;
import com.tianxing.components.mediator.ComponentMediatorImpl;
import com.tianxing.oauth.OAuthAuthorizationServer;
import com.tianxing.oauth.OAuthResourceServer;
import com.tianxing.oauth.t.TAuthorizationServerConfig;
import com.tianxing.oauth.t.TResourceServerConfig;
import com.tianxing.oauth.t.TSecurityConfig;
import com.tianxing.security.SecurityConfig;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * Created by tianxing on 2017/4/11.
 */

@Configuration
@ComponentScan(basePackageClasses = {
        AccountController.class,
        AssignmentService.class,
        InfoController.class,
        SecurityConfig.class,
        //MvcConfig.class,
        OAuthAuthorizationServer.class,
        OAuthResourceServer.class,
        //TAuthorizationServerConfig.class,
        //TResourceServerConfig.class,
        //TSecurityConfig.class
        })
public class FscConfig {


    @Bean
    public ComponentMediator serviceMediator() {

        ComponentMediator mediator = new ComponentMediatorImpl();
        //依次注册各个功能模块

        return mediator;
    }


    /**
     * 往嵌入式tomcat中加入其它war包
     */
    @Bean
    public EmbeddedServletContainerFactory ServletContainerFactory() {
        return new TomcatEmbeddedServletContainerFactory() {

            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
                // 确保webapp文件夹存在
                /*new File(tomcat.getServer().getCatalinaBase(), "webapp").mkdirs();
                try {
                    Context context = tomcat.addWebapp("/", "/cas.war");
                    //允许webapp加载springBoot包中的类
                    context.setParentClassLoader(getClass().getClassLoader());
                } catch (ServletException e) {
                    throw new IllegalStateException("添加war文件失败", e);
                }*/
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
        };
    }
}
