package com.zretc.controller.emp;

import com.zretc.entity.Dept;
import com.zretc.entity.Emp;
import com.zretc.service.DeptService;
import com.zretc.service.EmpService;
import com.zretc.service.impl.DeptServiceImpl;
import com.zretc.service.impl.EmpServiceImpl;
import com.zretc.util.DateUtils;
import com.zretc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "empController",urlPatterns = "/back/emp")
public class EmpController extends HttpServlet {
    EmpService es=new EmpServiceImpl();
    DeptService ds=new DeptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String msg=req.getParameter("msg");

        if ("listEmp".equals(msg)){
            listEmp(req,resp);
        }else if ("selectEmpByNo".equals(msg)){
            selectEmpByNo(req,resp);
        }else if ("insert".equals(msg)){
            insert(req,resp);
        }else if ("addEmp".equals(msg)){
            addEmp(req,resp);
        }else if ("updateEmp".equals(msg)){
            updateEmp(req,resp);
        }else if ("delete".equals(msg)){
            delete(req,resp);
        }else if("elTest".equals(msg)){
            elTest(req,resp);
        }

    }

    /**
     * 根据编号删除员工
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        int empNo= Integer.parseInt(req.getParameter("empNo"));
        boolean flag=es.deleteEmpById(empNo);
        if (flag){
            listEmp(req,resp);
        }
    }

    /**
     * 修改员工数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void updateEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取数据
        int empNo= Integer.parseInt(req.getParameter("empNo"));
        String empName= req.getParameter("empName");
        String job= req.getParameter("job");
        int mgr= Integer.parseInt(req.getParameter("mgr"));
        Date hireDate= DateUtils.strToDate(req.getParameter("hireDate"));
        Double sal= Double.valueOf(req.getParameter("sal"));
        Double comm= Double.valueOf(req.getParameter("comm"));
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));

        Emp emp=new Emp();
        emp.setEmpNo(empNo);
        emp.seteName(empName);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHireDate(hireDate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDept(ds.selectDeptById(deptNo));

        boolean flag=es.updateEmp(emp);
        if (flag){
            listEmp(req,resp);
        }
    }

    /**
     * 添加员工
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //获取数据
        int empNo= Integer.parseInt(req.getParameter("empNo"));
        String empName= req.getParameter("empName");
        String job= req.getParameter("job");
        int mgr= Integer.parseInt(req.getParameter("mgr"));
        Date hireDate= DateUtils.strToDate(req.getParameter("hireDate"));
        Double sal= Double.valueOf(req.getParameter("sal"));
        Double comm= Double.valueOf(req.getParameter("comm"));
        int deptNo= Integer.parseInt(req.getParameter("deptNo"));

        Emp emp=new Emp();
        emp.setEmpNo(empNo);
        emp.seteName(empName);
        emp.setJob(job);
        emp.setMgr(mgr);
        emp.setHireDate(hireDate);
        emp.setSal(sal);
        emp.setComm(comm);
        emp.setDept(ds.selectDeptById(deptNo));

        boolean flag=es.addEmp(emp);
        if (flag){
            listEmp(req,resp);
        }

    }

    /**
     * 跳转添加页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps = es.selectManager();
        List<Dept> depts = ds.listDept();
        //转发与传值
        req.setAttribute("emps",emps);
        req.setAttribute("depts",depts);
        req.getRequestDispatcher("/backend/emp/addEmp.jsp").forward(req,resp);
    }

    /**
     * 根据id查找员工（修改数据回显）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void selectEmpByNo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int emoNo= Integer.parseInt(req.getParameter("empNo"));
        Emp emp = es.selectEmpByNo(emoNo);
        List<Emp> emps = es.selectManager();
        List<Dept> depts = ds.listDept();
        //转发与传值
        req.setAttribute("emps",emps);
        req.setAttribute("depts",depts);
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("/backend/emp/updateEmp.jsp").forward(req,resp);
    }

    /**
     * 展示所有员工
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void listEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*查询全部员工
        List<Emp> list = es.listEmp();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/backend/emp/listEmp.jsp").forward(req,resp);*/
        //分页查询员工
        String pageNum=req.getParameter("pageNum");
        int num=pageNum!=null? Integer.parseInt(pageNum) :1;
        Page<Emp> empPage=es.listByPage(num,4);
        req.setAttribute("empPage",empPage);

        req.getRequestDispatcher("/backend/emp/listEmp.jsp").forward(req,resp);
    }




    /**
     * el表达式测试
     * http://localhost:8080/web0918_maven/back/emp?msg=elTest&empNo=7788
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    private void elTest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int emoNo= Integer.parseInt(req.getParameter("empNo"));
        Emp emp = es.selectEmpByNo(emoNo);
        List<Emp> emps = es.selectManager();
        List<Dept> depts = ds.listDept();
        //转发与传值
        req.setAttribute("emps",emps);
        req.setAttribute("depts",depts);
        req.setAttribute("emp",emp);
        req.getRequestDispatcher("/test/elTest.jsp").forward(req,resp);
    }
}
