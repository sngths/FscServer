package com.tianxing.data.account;

import com.tianxing.database.dao.result.UserInfo;
import com.tianxing.database.exception.UserAlreadyExistException;
import com.tianxing.database.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by tianxing on 17/1/13.
 */
public class UserManager {

    private SqlSessionFactory factory;


    public UserManager(SqlSessionFactory factory){
        if (factory == null){
            throw new NullPointerException();
        }
        this.factory = factory;
    }



    /**
     * 创建一个学生用户账号
     * */
    public void createStudent(String username, String password) throws UserAlreadyExistException {
        createUser(username, password, "s");
    }


    /**
     * 创建一个老师用户账号
     * */
    public void createTeacher(String username, String password) throws UserAlreadyExistException {
        createUser(username, password, "t");
    }









    /**
     * 创建一个用户
     * */
    private void createUser(String username, String password, String userType) throws UserAlreadyExistException {

        SqlSession session = factory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            UserInfo userInfo = mapper.getUserInfoByName(username);
            if (userInfo != null){
                if (userInfo.getUsername().equals(username)){
                    throw new UserAlreadyExistException();
                }
            }
            mapper.createUser(-1, username, password, userType);
            session.commit();
        }catch (Exception e){
            session.rollback();
            throw e;
        }finally {
            session.close();
        }
    }

}
