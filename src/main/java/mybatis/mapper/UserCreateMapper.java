package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by tianxing on 2016/12/27.
 *
 */
public interface UserCreateMapper {

    void create(@Param("username") String username, @Param("password") String password, @Param("email") String email);
}
