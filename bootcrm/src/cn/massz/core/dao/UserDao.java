package cn.massz.core.dao;

import cn.massz.core.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Dao接口
 */
public interface UserDao {
    /**
     * 通过账号和密码查找用户
     */
    User findUser(@Param("usercode")String usercode, @Param("password")String password);

}
