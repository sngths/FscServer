package com.tianxing.test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tianxing on 2016/11/19.
 *
 */
public class JacksonTest {

    public void a(){
        ObjectMapper objectMapper = new ObjectMapper();

        //解析
        try {
            User user = objectMapper.readValue(new File(""), User.class);
            User user1 = objectMapper.readValue("", User.class);
            Map<String, User> userMap = objectMapper.readValue("", new TypeReference<Map<String, User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写入
        User user = new User();
        try {

            objectMapper.writeValue(new File(""), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    private class User{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
