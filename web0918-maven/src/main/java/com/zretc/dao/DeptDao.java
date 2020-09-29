package com.zretc.dao;

import com.zretc.entity.Dept;
import com.zretc.util.Page;

import java.util.List;

public interface DeptDao {
    //查找全部部门
    List<Dept> listDept();
    //根据id查找部门
    Dept selectDeptById(int id);
    //根据名称模糊查询
    List<Dept> selectDeptLikeName(String key);
    //添加部门
    boolean addDept(Dept dept);
    //根据id删除部门
    boolean deleteDeptById(int id);
    //修改部门
    boolean updateDept(Dept dept);
    //分页查找
    Page<Dept> selectByPage(int currentPage,int pageSize);
}
