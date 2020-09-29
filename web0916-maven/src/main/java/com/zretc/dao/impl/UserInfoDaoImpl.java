package com.zretc.dao.impl;

import com.zretc.dao.UserInfoDao;
import com.zretc.entity.UserInfo;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDaoImpl implements UserInfoDao {
    @Override
    public boolean addUser(UserInfo userInfo) {
        String sql="insert into users(username,password,email) values(?,?,?)";
        int n=DBUtil.exUpdate(sql,userInfo.getUserName(),userInfo.getPassword(),userInfo.getEmail());
        return n>0;
    }

    @Override
    public UserInfo selectUser(String username, String pwd) {
        String sql="select * from users where username=? and password=?";
        ResultSet rs=DBUtil.exQuery(sql,username,pwd);
        UserInfo userInfo=null;
        try {
            if (rs.next()){
                userInfo=new UserInfo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
