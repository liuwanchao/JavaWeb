package com.zretc.test;

import com.zretc.service.UserService;
import com.zretc.service.impl.UserServiceImpl;
import org.junit.Test;

public class LoginTest {
    UserService us=new UserServiceImpl();
    @Test
    public void da(){
        System.out.println(us.selectUser("admin","admin"));
    }
}
