package com.zretc.service.impl;

import com.zretc.dao.UserInfoDao;
import com.zretc.dao.impl.UserInfoDaoImpl;
import com.zretc.entity.UserInfo;
import com.zretc.service.UserInfoService;
import com.zretc.util.MD5Utils;

public class UserInfoServiceImpl implements UserInfoService {
    UserInfoDao uid=new UserInfoDaoImpl();
    @Override
    public boolean addUser(UserInfo userInfo) {
        String pwd= MD5Utils.stringToMD5(userInfo.getPassword());
        userInfo.setPassword(pwd);
        System.out.println(userInfo);
        return uid.addUser(userInfo);
    }

    @Override
    public UserInfo selectUser(String username, String pwd) {
        pwd= MD5Utils.stringToMD5(pwd);
        return uid.selectUser(username,pwd);
    }
}
