package cn.massz.core.service.impl;

import cn.massz.core.dao.UserDao;
import cn.massz.core.po.User;
import cn.massz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户User接口实现层
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
//    注入UserDao
    @Autowired
    private UserDao userDao;
    //通过密码和账号查询
    @Override
    public User findUser(String usercode, String password) {
        User user = userDao.findUser(usercode, password);
        return user;
    }
}
