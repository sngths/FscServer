package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tianxing on 16/10/22.
 *
 */

public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUser(String username);

}
