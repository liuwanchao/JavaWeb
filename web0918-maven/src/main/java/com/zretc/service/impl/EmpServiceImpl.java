package com.zretc.service.impl;

import com.zretc.dao.EmpDao;
import com.zretc.dao.impl.EmpDaoImpl;
import com.zretc.entity.Emp;
import com.zretc.service.EmpService;
import com.zretc.util.Page;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    EmpDao ed=new EmpDaoImpl();
    @Override
    public boolean addEmp(Emp emp) {
        Emp e=ed.selectEmpByNo(emp.getEmpNo());
        if (e==null){
            return false;
        }
        return ed.addEmp(emp);
    }

    @Override
    public boolean deleteEmpById(int empNo) {
        return ed.deleteEmpById(empNo);
    }

    @Override
    public boolean updateEmp(Emp emp) {
        return ed.updateEmp(emp);
    }

    @Override
    public List<Emp> listEmp() {
        return ed.listEmp();
    }

    @Override
    public Emp selectEmpByNo(int empNo) {
        return ed.selectEmpByNo(empNo);
    }

    @Override
    public List<Emp> listEmpLikeName(String eName) {
        return ed.listEmpLikeName(eName);
    }

    @Override
    public List<Emp> selectManager() {
        return ed.selectManager();
    }

    @Override
    public Page<Emp> listByPage(int currentPage, int pageSize) {
        return ed.listByPage(currentPage, pageSize);
    }
}
