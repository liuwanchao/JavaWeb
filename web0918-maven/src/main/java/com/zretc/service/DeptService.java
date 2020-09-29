package com.zretc.service;

import com.zretc.entity.Dept;
import com.zretc.util.Page;

import java.util.List;

public interface DeptService {
    List<Dept> listDept();
    Dept selectDeptById(int id);
    boolean addDept(Dept dept);
    boolean deleteDeptById(int id);
    boolean updateDept(Dept dept);
    //根据名称模糊查询
    List<Dept> selectDeptLikeName(String key);

    //分页查找
    Page<Dept> selectByPage(int currentPage, int pageSize);
}
