package com.zretc.listener;

import com.zretc.util.DBUtil2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebListener("VisitCountListener")
public class VisitCountListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String sql="select num from count";
        ResultSet rs = DBUtil2.exQuery(sql);
        int num=0;
        try {
            if (rs.next()){
                num=rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        servletContextEvent.getServletContext().setAttribute("num",num);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        String sql="update count set num=?";
        DBUtil2.exUpdate(sql,(int)servletContextEvent.getServletContext().getAttribute("num"));
    }
}
