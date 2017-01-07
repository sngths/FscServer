package com.tianxing.database.mapper;

import com.tianxing.database.dao.result.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tianxing on 16/12/30.
 * 用户信息相关的数据库操作
 */
public interface UserMapper {

    /**
     * 根据用户ID查询到用户信息
     * */
    @Select("SELECT * FROM user WHERE id = #{id}")
    UserInfo getUserInfoByID(Long id);


    /**
     * 根据用户名查询到一条用户信息
     * */
    @Select("SELECT * FROM user WHERE username = #{username}")
    UserInfo getUserInfoByName(String username);






    /**
     * 创建一个学生用户
     * */
    int createStudent(@Param("username") String username, @Param("password") String password);

    /**
     * 创建一个老师用户
     * */
    int createTeacher(@Param("username") String username, @Param("password") String password);

}
