package com.zretc.test;

import com.zretc.dao.EmpDao;
import com.zretc.dao.impl.EmpDaoImpl;
import com.zretc.entity.Emp;

public class EmpTest {
    public static void main(String[] args) {

        EmpDao ed=new EmpDaoImpl();
        Emp emp=new Emp(1,"张三丰",6576,3);
        //添加员工
        System.out.println("添加员工"+ed.addEmp(emp));
        System.out.println("删除编号为11的员工"+ed.deleteEmpByEid(11));
        System.out.println("修改编号为10的员工工资为11111"+ed.updateSalaryByEid(new Emp(10,"",11111,1)));
        System.out.println("所有员工");
        ed.listEmp().forEach(System.out::println);
        System.out.println("工资高于5000的员工");
        ed.selectEmpBySalary(5000).forEach(System.out::println);
        System.out.println("姓张的员工");
        ed.selectEmplikeEname("张%").forEach(System.out::println);
        System.out.println("编号为10的员工所在部门"+ed.selectDeptByEid(10));
    }
}
