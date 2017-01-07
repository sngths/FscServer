package com.tianxing.database;

import com.tianxing.database.dao.result.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by tianxing on 16/12/30.
 * 
 */
public interface AssignmentMapper {

    UserInfo insert(@Param("username") String username);
    
}
