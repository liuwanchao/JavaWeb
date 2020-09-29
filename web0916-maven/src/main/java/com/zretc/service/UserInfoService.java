package com.zretc.service;

import com.zretc.entity.UserInfo;

public interface UserInfoService {
    //添加用户
    boolean addUser(UserInfo userInfo);
    //根据账号密码查询用户
    UserInfo selectUser(String username,String pwd);
}
