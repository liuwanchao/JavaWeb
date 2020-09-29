package com.zretc.service;

import com.zretc.entity.UserInfo;

public interface UserService {
    //根据账号密码查询用户
    UserInfo selectUser(String username, String pwd);
}
