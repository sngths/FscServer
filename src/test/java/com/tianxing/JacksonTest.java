package com.tianxing;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tianxing.pojo.http.ResponseWrapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by tianxing on 2016/11/19.
 *
 */
public class JacksonTest {


     private ObjectMapper mapper = new ObjectMapper();

    public void a(){
        //解析
        try {
            User user = mapper.readValue(new File(""), User.class);
            User user1 = mapper.readValue("", User.class);
            mapper.readValue(new byte[3], User.class);

            Map<String, User> userMap = mapper.readValue("", new TypeReference<Map<String, User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        //写入
        User user = new User();
        try {

            mapper.writeValue(new File(""), user);
            //mapper.writeValue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //
    private void encode(ByteBuf buf) throws IOException {
        ByteBufInputStream inputStream = new ByteBufInputStream(buf);
        User user = mapper.readValue((InputStream) inputStream, User.class);
    }


    private void decode(User user){

    }





    private static class User{
        private String id;
        private int age;
        //@JsonDeserialize(using = StringDeserializer.class)
        private String name;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }


    /**
     * 用于编解码的内部类 必须定义为静态类型
     * */
    private static class Name{
        private String first = "firstName";
        private String last = "lastName";

        public String getFirst() {
            return first;
        }
        public String getLast() {
            return last;
        }
    }

    private class RawUser{
        private String id = "rawID";

        //@JsonRawValue
        private String name;

        public RawUser(String rawName){
            this.name = rawName;
        }
        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @JsonGetter("age")
        public int getAge(){
            return 15;
        }

    }

    /**
     * 自定义解码器
     * */
    private static class StringDeserializer extends JsonDeserializer<String>{

        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            return p.getText();
        }
    }

    @Test
    public void rawValue(){

        try {
            RawUser rawUser = new RawUser(mapper.writeValueAsString(new Name()));
            String s = mapper.writeValueAsString(rawUser);
            System.out.println(s);
            User user = mapper.readValue(s, User.class);
            Name name = mapper.readValue(user.getName(), Name.class);
            System.out.println(mapper.writeValueAsString(name));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void emptyObject(){
        try {
            User user = mapper.readValue("{}", User.class);
        } catch (IOException e) {
            //e.printStackTrace();
        }

        User user1= new User();

        try {
            RawUser rawUser = new RawUser(mapper.writeValueAsString(new Name()));
            String s = mapper.writeValueAsString(user1);
            mapper.writeValue(System.out, user1);
            String s1 = mapper.writeValueAsString(rawUser);
            System.out.println(s1);
            RawUser user2 = mapper.readValue(s1, RawUser.class);
            mapper.writeValue(System.out, user2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void jsonBytes(){
        try {
            Object o = new Name();
            String s = mapper.writeValueAsString(o);
            byte[] bytes = mapper.writeValueAsBytes(new Name());
            System.out.println(s);
            Name name = mapper.readValue(s, Name.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void hashValue(){
        System.out.println(String.class.getName().hashCode());
        System.out.println(ResponseWrapper.class.getName());
        System.out.println(ResponseWrapper.class.getName().hashCode());
        System.out.println(String.valueOf(0).hashCode());
    }
}
