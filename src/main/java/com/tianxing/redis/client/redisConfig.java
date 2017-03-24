package com.tianxing.redis.client;

/**
 * Created by tianxing on 2017/3/24.
 * redis参数配置
 */
public class RedisConfig {


    private String host;
    private int port;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;


    private RedisConfig(){}

    public static class Builder{
        private static final String DEFAULT_HOST = "127.0.0.1";
        private static final int DEFAULT_PORT = 6379;
        private static final int DEFAULT_MAX_TOTAL = 5;
        private static final int DEFAULT_MAX_IDLE = 3;
        private static final int DEFAULT_MIN_IDLE = 1;

        private String host;
        private Integer port;
        private Integer maxTotal;
        private Integer maxIdle;
        private Integer minIdle;


        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        public Builder setPort(Integer port) {
            this.port = port;
            return this;
        }

        public Builder setMaxTotal(Integer maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(Integer maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(Integer minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public RedisConfig build(){
            RedisConfig config = new RedisConfig();
            if (host != null){
                config.setHost(host);
            }else {
                config.setHost(DEFAULT_HOST);
            }
            if (port != null){
                config.setPort(port);
            }else {
                config.setPort(DEFAULT_PORT);
            }
            if (maxTotal != null){
                config.setMaxTotal(maxTotal);
            }else {
                config.setMaxTotal(DEFAULT_MAX_TOTAL);
            }
            if (maxIdle != null){
                config.setMaxIdle(maxIdle);
            }else {
                config.setMaxIdle(DEFAULT_MAX_IDLE);
            }
            if (minIdle != null){
                config.setMinIdle(minIdle);
            }else {
                config.setMinIdle(DEFAULT_MIN_IDLE);
            }
            return config;
        }


        public RedisConfig buildDefault(){
            RedisConfig config = new RedisConfig();
            config.setHost(DEFAULT_HOST);
            config.setPort(DEFAULT_PORT);
            config.setMaxTotal(DEFAULT_MAX_TOTAL);
            config.setMaxIdle(DEFAULT_MAX_IDLE);
            config.setMinIdle(DEFAULT_MIN_IDLE);
            return config;
        }
    }

    protected void setHost(String host) {
        this.host = host;
    }

    protected void setPort(int port) {
        this.port = port;
    }

    protected void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    protected void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    protected void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public int getMaxIdle() {
        return maxIdle;
    }
}
