package com.zretc.dao.impl;

import com.zretc.dao.DeptDao;
import com.zretc.entity.Dept;
import com.zretc.util.DBUtil2;
import com.zretc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> listDept() {
        List<Dept> list=new ArrayList<>();
        String sql="select * from dept";
        ResultSet rs= DBUtil2.exQuery(sql);
        try {
            while (rs.next()){
                Dept dept=new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil2.close();
        return list;
    }

    @Override
    public Dept selectDeptById(int id) {
        Dept dept=null;
        String sql="select * from dept where deptno=?";
        ResultSet rs= DBUtil2.exQuery(sql,id);
        try {
            if (rs.next()){
                dept=new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil2.close();
        return dept;
    }

    @Override
    public  List<Dept> selectDeptLikeName(String key) {
        List<Dept> list=new ArrayList<>();
        String sql="select * from dept where dname like ?";
        ResultSet rs= DBUtil2.exQuery(sql,"%"+key+"%");
        try {
            while (rs.next()){
                Dept dept=new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil2.close();
        return list;
    }

    @Override
    public boolean addDept(Dept dept) {
        String sql="insert into dept values(?,?,?)";
        int n= DBUtil2.exUpdate(sql,dept.getDeptNo(),dept.getdName(),dept.getLoc());
        return n>0;
    }

    @Override
    public boolean deleteDeptById(int id) {
        String sql="delete from dept where deptno=?";
        int n= DBUtil2.exUpdate(sql,id);
        return n>0;
    }

    @Override
    public boolean updateDept(Dept dept) {
        String sql="update dept set dname=?,loc=? where deptno=?";
        int n= DBUtil2.exUpdate(sql,dept.getdName(),dept.getLoc(),dept.getDeptNo());
        return n>0;
    }
    /**
     * 查询总记录数
     * @return
     */
    private int empCount(){
        String sql="SELECT count(1) from dept";
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

    @Override
    public Page<Dept> selectByPage(int currentPage, int pageSize) {
        Page<Dept> page=new Page<>(currentPage,pageSize);
        page.setTotalData(empCount());
        List<Dept> list=new ArrayList<>();
        String sql="select * from dept limit ?,?";
        ResultSet rs= DBUtil2.exQuery(sql,page.start(),pageSize);
        try {
            while (rs.next()){
                Dept dept=new Dept(rs.getInt(1),rs.getString(2),rs.getString(3));
                list.add(dept);
            }
            page.setData(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil2.close();
        return page;
    }
}
