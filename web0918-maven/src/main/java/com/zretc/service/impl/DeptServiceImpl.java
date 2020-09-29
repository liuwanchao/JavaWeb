package com.zretc.service.impl;

import com.zretc.dao.DeptDao;
import com.zretc.dao.impl.DeptDaoImpl;
import com.zretc.entity.Dept;
import com.zretc.service.DeptService;
import com.zretc.util.Page;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao dd=new DeptDaoImpl();
    @Override
    public List<Dept> listDept() {
        return dd.listDept();
    }

    @Override
    public Dept selectDeptById(int id) {
        return dd.selectDeptById(id);
    }

    @Override
    public boolean addDept(Dept dept) {
        return dd.addDept(dept);
    }

    @Override
    public boolean deleteDeptById(int id) {
        return dd.deleteDeptById(id);
    }

    @Override
    public boolean updateDept(Dept dept) {
        return dd.updateDept(dept);
    }

    @Override
    public List<Dept> selectDeptLikeName(String key) {
        return dd.selectDeptLikeName(key);
    }

    @Override
    public Page<Dept> selectByPage(int currentPage, int pageSize) {
        return dd.selectByPage(currentPage, pageSize);
    }
}
