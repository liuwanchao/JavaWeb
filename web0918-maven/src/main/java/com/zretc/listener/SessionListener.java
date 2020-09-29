package com.zretc.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;

@WebListener("SessionListener")
public class SessionListener implements HttpSessionAttributeListener {


    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session添加"+httpSessionBindingEvent.getName()+".."+httpSessionBindingEvent.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session移除"+httpSessionBindingEvent.getName()+".."+httpSessionBindingEvent.getValue());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("session修改"+httpSessionBindingEvent.getName()+".."+httpSessionBindingEvent.getValue());

    }
}
