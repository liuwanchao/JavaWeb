package com.zretc.controller.dept;

import com.google.gson.Gson;
import com.zretc.entity.Dept;
import com.zretc.entity.Product;
import com.zretc.service.DeptService;
import com.zretc.service.ProductService;
import com.zretc.service.impl.DeptServiceImpl;
import com.zretc.service.impl.ProductServiceImpl;
import com.zretc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "deptController",urlPatterns = "/back/dept")
public class DeptController extends HttpServlet {
    DeptService ds=new DeptServiceImpl();
    ProductService ps=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg=req.getParameter("msg");
        if ("listDept".equals(msg)){
            listDept(req,resp);
        }else if ("selectDeptByNo".equals(msg)){
            selectDeptByNo(req,resp);
        }else if ("deleteDept".equals(msg)){
            deleteDept(req,resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String msg=req.getParameter("msg");
        if ("updateDept".equals(msg)){
            updateDept(req,resp);
        }else if ("addDept".equals(msg)){
            addDept(req,resp);
        }else if ("selectLike".equals(msg)){
            selectLike(req,resp);
        }else if ("selectpro".equals(msg)){
            selectpro(req,resp);
        }
    }

    private void selectpro(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("pName");
        if (name==null){
            name="";
        }
        List<Product> list = ps.selectLikeName(name);
        //格式转化
        Gson gson=new Gson();
        String products=gson.toJson(list);
        //发送数据
        PrintWriter out = resp.getWriter();
        out.write(products);
        out.flush();
    }

    private void selectLike(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        String key=req.getParameter("dName");
        List<Dept> list=ds.selectDeptLikeName(key);
        list.forEach(System.out::println);
        //格式转化
        Gson gson=new Gson();
        String depts=gson.toJson(list);
        //发送数据
        PrintWriter out=resp.getWriter();
        out.write(depts);
        out.flush();
    }

    /**
     * 添加部门信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取数据
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));
        String dName=req.getParameter("dName");
        String loc=req.getParameter("loc");
        Dept dept=new Dept(deptNo,dName,loc);

        boolean flag=ds.addDept(dept);
        if (flag){
            listDept(req,resp);
        }
    }
    /**
     * 删除部门
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void deleteDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));
        boolean flag=ds.deleteDeptById(deptNo);
        if (flag){
            listDept(req,resp);
        }
    }

    /**
     * 修改部门信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //设置编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        //获取数据
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));
        String dName=req.getParameter("dName");
        String loc=req.getParameter("loc");
        Dept dept=new Dept(deptNo,dName,loc);

        boolean flag=ds.updateDept(dept);
        if (flag){
            listDept(req,resp);
        }
    }

    /**
     * 修改回显数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectDeptByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));
        Dept dept= ds.selectDeptById(deptNo);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("/backend/dept/updateDept.jsp").forward(req,resp);
    }
    /**
     * 查询全部部门
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void listDept(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        /*查询全部
        List<Dept> list=ds.listDept();
        req.setAttribute("depts",list);
        req.getRequestDispatcher("/backend/dept/listDept.jsp").forward(req,resp);*/
        //分页查询
        //获取当前页数
        String pageNum=req.getParameter("pageNum");
        int num=pageNum!=null? Integer.parseInt(pageNum) :1;

        Page<Dept> deptPage=ds.selectByPage(num,5);
        req.setAttribute("deptPage",deptPage);

        req.getRequestDispatcher("/backend/dept/listDept.jsp").forward(req,resp);

    }
}
