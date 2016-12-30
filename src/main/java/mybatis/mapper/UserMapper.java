package mybatis.mapper;

import mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by tianxing on 16/10/22.
 *
 */
@Alias("userMapper")
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User> getUser(String username);

}
