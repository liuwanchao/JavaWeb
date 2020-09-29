package com.zretc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

@WebListener("SessionListener")
public class SessionListener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getSession().setAttribute("msg","请登录后访问");
        //跳转到登录页面
    }
}
