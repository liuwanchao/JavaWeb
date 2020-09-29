package com.zretc.dao;

import com.zretc.entity.UserInfo;

public interface UserDao {
    //根据账号密码查询用户
    //更新测试
    UserInfo selectUser(String username, String pwd);
}
