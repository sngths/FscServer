package com.tianxing.database.mapper;

import com.tianxing.database.dao.result.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tianxing on 16/12/30.
 * 用户信息相关的数据库操作
 */
public interface UserMapper {

    /**
     * 根据用户ID查询到用户信息
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    UserInfo getUserInfoByID(Long id);


    /**
     * 根据用户名查询到一条用户信息
     */
    @Select("SELECT * FROM user WHERE username = #{username}")
    UserInfo getUserInfoByName(String username);


    /**
     * 创建一个用户
     * @param userType "s"表示学生用户 "t"表示老师用户
     */
    int createUser(@Param("id") Integer id,@Param("username") String username, @Param("password") String password, @Param("userType") String userType);



    /**
     * 创建一个班级
     * */
    @Insert("INSERT INTO classInfo (class, grade, name, info) VALUES (#{class}, #{grade}, #{name}, #{info})")
    int createClass(@Param("class") int Class, @Param("grade") int grade, @Param("name") String name ,@Param("info") String info);


    /**
     * 查询一个班级的信息
     * */


    /**
     * 学生添加班级
     * */


    /**
     * 老师添加班级
     * */
}
