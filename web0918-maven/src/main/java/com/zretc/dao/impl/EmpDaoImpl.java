package com.zretc.dao.impl;

import com.zretc.dao.EmpDao;
import com.zretc.entity.Dept;
import com.zretc.entity.Emp;
import com.zretc.util.DBUtil2;
import com.zretc.util.DButil3;
import com.zretc.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public boolean addEmp(Emp emp) {
        String sql="insert into emp values(?,?,?,?,?,?,?,?)";
        int n=DBUtil2.exUpdate(sql,emp.getEmpNo(),emp.geteName(),emp.getJob(),emp.getMgr(),emp.getHireDate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptNo());
        return n>0;
    }

    @Override
    public boolean deleteEmpById(int empNo) {
        String sql="delete from emp where empno=?";
        int n=DBUtil2.exUpdate(sql,empNo);
        return n>0;
    }

    @Override
    public boolean updateEmp(Emp emp) {
        String sql="update emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?";
        int n=DBUtil2.exUpdate(sql,emp.geteName(),emp.getJob(),emp.getMgr(),emp.getHireDate(),emp.getSal(),emp.getComm(),emp.getDept().getDeptNo(),emp.getEmpNo());
        return false;
    }

    @Override
    public List<Emp> listEmp() {
        List<Emp> list=new ArrayList<>();
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,dept.deptno,dname,loc from emp INNER JOIN dept on dept.deptno=emp.deptno";
        ResultSet rs=DBUtil2.exQuery(sql);
        try {
            while (rs.next()){
                Emp emp=new Emp();
                emp.setEmpNo(rs.getInt("empno"));
                emp.seteName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHireDate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        return list;
    }

    @Override
    public Emp selectEmpByNo(int empNo) {
        Emp emp=new Emp();
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,dept.deptno,dname,loc from emp INNER JOIN dept on dept.deptno=emp.deptno where empno=?";
        ResultSet rs=DBUtil2.exQuery(sql,empNo);
        try {
            if (rs.next()){
                emp.setEmpNo(rs.getInt(1));
                emp.seteName(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHireDate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        return emp;
    }

    @Override
    public Emp selectEmpByNo(String eName) {
        Emp emp=new Emp();
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,dept.deptno,dname,loc from emp INNER JOIN dept on dept.deptno=emp.deptno where ename=?";
        ResultSet rs=DBUtil2.exQuery(sql,eName);
        try {
            if (rs.next()){
                emp.setEmpNo(rs.getInt(1));
                emp.seteName(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHireDate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        return emp;
    }

    @Override
    public List<Emp> listEmpLikeName(String eName) {
        List<Emp> list=new ArrayList<>();
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,dept.deptno,dname,loc from emp INNER JOIN dept where ename like '%'?'%'";
        ResultSet rs=DBUtil2.exQuery(sql,eName);
        try {
            while (rs.next()){
                Emp emp=new Emp();
                emp.setEmpNo(rs.getInt(1));
                emp.seteName(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHireDate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        return list;
    }

    @Override
    public List<Emp> selectManager() {
        List<Emp> list=new ArrayList<>();
        String sql="SELECT * from emp e,dept d where empno in(select distinct mgr from emp where mgr is not null) and e.deptno=d.deptno";
        Connection conn=DButil3.getConnection();
        PreparedStatement pstmt = DButil3.getPstmt(conn, sql);
        ResultSet rs=DButil3.query(pstmt);
        try {
            while (rs.next()){
                Emp emp=new Emp();
                emp.setEmpNo(rs.getInt(1));
                emp.seteName(rs.getString(2));
                emp.setJob(rs.getString(3));
                emp.setMgr(rs.getInt(4));
                emp.setHireDate(rs.getDate(5));
                emp.setSal(rs.getDouble(6));
                emp.setComm(rs.getDouble(7));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DButil3.close(conn,pstmt,rs);
        }
        return list;
    }

    /**
     * 查询总记录数
     * @return
     */
    private int empCount(){
        String sql="SELECT count(1) from emp";
        ResultSet rs=DBUtil2.exQuery(sql);
        int n= 0;
        try {
            if (rs.next()){
               n=rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
       return n;
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public Page<Emp> listByPage(int currentPage, int pageSize) {
        Page<Emp> page=new Page<>(currentPage,pageSize);
        page.setTotalData(empCount());
        List<Emp> list=new ArrayList<>();
        String sql="select empno,ename,job,mgr,hiredate,sal,comm,dept.deptno,dname,loc from emp INNER JOIN dept on dept.deptno=emp.deptno limit ?,?";
        ResultSet rs=DBUtil2.exQuery(sql,page.start(),pageSize);
        try {
            while (rs.next()){
                Emp emp=new Emp();
                emp.setEmpNo(rs.getInt("empno"));
                emp.seteName(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setHireDate(rs.getDate("hiredate"));
                emp.setSal(rs.getDouble("sal"));
                emp.setComm(rs.getDouble("comm"));
                emp.setDept(new Dept(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc")));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil2.close();
        }
        page.setData(list);
        return page;
    }

}
