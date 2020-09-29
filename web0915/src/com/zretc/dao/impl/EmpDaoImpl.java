package com.zretc.dao.impl;

import com.zretc.dao.EmpDao;
import com.zretc.entity.Dept;
import com.zretc.entity.Emp;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public boolean addEmp(Emp emp) {
        String sql = "insert into emp values(0,?,?,?)";
        int n=DBUtil.exUpdate(sql,emp.getEname(),emp.getSalary(),emp.getDeptid());
        return n > 0;
    }

    @Override
    public boolean deleteEmpByEid(int eid) {
        String sql = "delete from emp where eid=?";
        int n=DBUtil.exUpdate(sql,eid);
        return n > 0;
    }

    @Override
    public boolean updateSalaryByEid(Emp emp) {
        String sql = "update emp set salary=? where eid=?";
        int n=DBUtil.exUpdate(sql,emp.getSalary(),emp.getEid());
        return n > 0;
    }

    @Override
    public List<Emp> listEmp() {
        List<Emp> list=new ArrayList<>();
        String sql = "select * from emp";
        ResultSet rs=DBUtil.exQuery(sql);
        try {
            while (rs.next()){
                Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
           DBUtil.close();
        }
        return list;
    }
    @Override
    public Emp selectEmpByEid(int eid) {
        Emp emp=null;
        String sql = "select * from emp where eid=?";
        ResultSet rs=DBUtil.exQuery(sql,eid);
        try {
            if (rs.next()){
               emp=new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return emp;
    }


    @Override
    public List<Emp> selectEmpBySalary(int salary) {
        List<Emp> list=new ArrayList<>();
        String sql = "select * from emp where salary>?";
        ResultSet rs=DBUtil.exQuery(sql,salary);
        try {
            while (rs.next()){
                Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public List<Emp> selectEmplikeEname(String ename) {
        List<Emp> list=new ArrayList<>();
        String sql = "select * from emp where ename like ?";
        ResultSet rs=DBUtil.exQuery(sql,ename);
        try {
            while (rs.next()){
                Emp emp=new Emp(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public Dept selectDeptByEid(int eid) {
        Dept dept=null;
        String sql = "select * from dept where deptid=(select deptid from emp where eid=?)";
        ResultSet rs=DBUtil.exQuery(sql,eid);
        try {
            while (rs.next()){
               dept=new Dept(rs.getInt(1),rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return dept;
    }
}
