package com.tianxing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.EmptyByteBuf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by tianxing on 2016/11/19.
 *
 */
public class JacksonTest {


    ObjectMapper objectMapper = new ObjectMapper();
    public void a(){


        //解析
        try {
            User user = objectMapper.readValue(new File(""), User.class);
            User user1 = objectMapper.readValue("", User.class);
            objectMapper.readValue(new byte[3], User.class);

            Map<String, User> userMap = objectMapper.readValue("", new TypeReference<Map<String, User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写入
        User user = new User();
        try {

            objectMapper.writeValue(new File(""), user);
            //objectMapper.writeValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //
    private void encode(ByteBuf buf) throws IOException {
        ByteBufInputStream inputStream = new ByteBufInputStream(buf);
        User user = objectMapper.readValue((InputStream) inputStream, User.class);
    }


    private void decode(User user){

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
