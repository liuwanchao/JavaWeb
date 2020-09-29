package com.zretc.dao;

import com.zretc.entity.Emp;
import com.zretc.util.Page;

import java.util.List;

public interface EmpDao {
    //添加员工
    boolean addEmp(Emp emp);
    //根据id删除员工
    boolean deleteEmpById(int empNo);
    //修改员工信息
    boolean updateEmp(Emp emp);
    //查询所有员工
    List<Emp> listEmp();
    //根据id查找员工
    Emp selectEmpByNo(int empNo);
    //根据姓名查找员工
    Emp selectEmpByNo(String eName);
    List<Emp> listEmpLikeName(String eName);
    //查询经理
    List<Emp> selectManager();
    //分页查询
    Page<Emp> listByPage(int currentPage,int pageSize);
}
