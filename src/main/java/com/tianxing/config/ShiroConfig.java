package com.tianxing.config;


/**
 * Created by tianxing on 16/10/7.
 *
 */

//@Configuration
public class ShiroConfig {

//    @Bean
//    ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
//        System.out.println("");
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//
//
//        return shiroFilterFactoryBean;
//    }
//
//    @Bean
//    SecurityManager securityManager(){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        return securityManager;
//    }


    /*@Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setLoginUrl("*//**");
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/index");
        shiroFilter.setUnauthorizedUrl("/forbidden");
        Map<String, String> filterChainDefinitionMapping = new HashMap<String, String>();
        filterChainDefinitionMapping.put("/", "anon");
        filterChainDefinitionMapping.put("/assignment/list", "roles[guest]");
        filterChainDefinitionMapping.put("/home", "authc,roles[guest]");
        filterChainDefinitionMapping.put("/admin", "authc,roles[admin]");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMapping);
        shiroFilter.setSecurityManager(securityManager());
        Map<String, Filter> filters = new HashMap<String, Filter>();
        filters.put("anon", new AnonymousFilter());
        filters.put("authc", new FormAuthenticationFilter());
        filters.put("logout", new LogoutFilter());
        filters.put("roles", new RolesAuthorizationFilter());
        filters.put("user", new UserFilter());
        shiroFilter.setFilters(filters);
        System.out.println(shiroFilter.getFilters().size());
        return shiroFilter;
    }*/

    /*@Bean(name = "securityManager")
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm());
        return securityManager;
    }*/

    /*@Bean(name = "realm")
    @DependsOn("lifecycleBeanPostProcessor")
    public PropertiesRealm realm() {
        PropertiesRealm propertiesRealm = new PropertiesRealm();
        propertiesRealm.init();
        return propertiesRealm;
    }*/

    /*@Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }*/













}
