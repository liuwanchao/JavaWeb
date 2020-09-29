package com.zretc.dao.impl;

import com.zretc.dao.UserDao;
import com.zretc.entity.UserInfo;
import com.zretc.util.DBUtil2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public UserInfo selectUser(String username, String pwd) {
        String sql="select * from user where username=? and password=?";
        ResultSet rs = DBUtil2.exQuery(sql, username, pwd);
        UserInfo user=new UserInfo();
        try {
            if (rs.next()){
                user.setId(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil2.close();
       return user;
    }
}
