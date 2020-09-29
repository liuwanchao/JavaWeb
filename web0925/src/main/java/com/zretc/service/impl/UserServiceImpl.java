package com.zretc.service.impl;

import com.zretc.dao.UserDao;
import com.zretc.dao.impl.UserDaoImpl;
import com.zretc.entity.UserInfo;
import com.zretc.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao ud=new UserDaoImpl();
    @Override
    public UserInfo selectUser(String username, String pwd) {
        return ud.selectUser(username,pwd);
    }
}
