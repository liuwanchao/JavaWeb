package com.zretc.dao;

import com.zretc.entity.Dept;
import com.zretc.entity.Emp;

import java.util.List;

public interface EmpDao {
    //添加员工
    boolean addEmp(Emp emp);
    //根据编号删除员工
    boolean deleteEmpByEid(int eid);
    //根据员工编号修改员工工资
    boolean updateSalaryByEid(Emp emp);
    //查询全部员工
    List<Emp> listEmp();
    //根据工资查询员工信息
    Emp selectEmpByEid(int eid);
    //根据工资查询员工信息
    List<Emp> selectEmpBySalary(int salary);
    //根据员工姓查找员工
    List<Emp> selectEmplikeEname(String ename);
    //根据员工编号查找其所在部门名称
    Dept selectDeptByEid(int eid);

}
