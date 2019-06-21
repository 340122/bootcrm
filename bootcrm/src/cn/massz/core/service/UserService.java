package cn.massz.core.service;

import cn.massz.core.po.User;

/**
 * 用户Service层接口
 */
public interface UserService {
    User findUser(String usercode,String password);
}
