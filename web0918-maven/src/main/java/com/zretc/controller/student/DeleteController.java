package com.zretc.controller.student;

import com.zretc.service.StudentService;
import com.zretc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteController",urlPatterns = "/student/delete")
public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentNo=req.getParameter("studentNo");
        StudentService ss=new StudentServiceImpl();
        ss.deleteStudentByNo(studentNo);
        resp.sendRedirect("/student/list");
    }
}
