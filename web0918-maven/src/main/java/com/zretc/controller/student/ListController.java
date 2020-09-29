package com.zretc.controller.student;

import com.zretc.entity.Student;
import com.zretc.service.StudentService;
import com.zretc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listController",urlPatterns = "/student/list")
public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentService  ss=new StudentServiceImpl();
        List<Student> list=ss.listStudent();

        //传递数据
        req.setAttribute("list",list);
        req.getRequestDispatcher("listStudent.jsp").forward(req,resp);

    }
}
