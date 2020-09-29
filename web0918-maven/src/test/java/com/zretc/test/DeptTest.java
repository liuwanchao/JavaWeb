package com.zretc.test;

import com.zretc.entity.Dept;
import com.zretc.service.DeptService;
import com.zretc.service.impl.DeptServiceImpl;
import org.junit.Test;

public class DeptTest {
    DeptService ds=new DeptServiceImpl();

    @Test
    public void list(){
        ds.listDept().forEach(System.out::println);
    }
    @Test
    public void select(){
        System.out.println(ds.selectDeptById(10));
    }
    @Test
    public void add(){
        ds.addDept(new Dept(1,"1","1"));
    }
    @Test
    public void update(){
        ds.updateDept(new Dept(1,"12","13"));
    }
    @Test
    public void delete(){
        ds.deleteDeptById(12);
    }

}
