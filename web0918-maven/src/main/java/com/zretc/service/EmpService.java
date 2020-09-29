package com.zretc.service;

import com.zretc.entity.Emp;
import com.zretc.util.Page;

import java.util.List;

public interface EmpService {
    boolean addEmp(Emp emp);

    boolean deleteEmpById(int empNo);

    boolean updateEmp(Emp emp);

    List<Emp> listEmp();

    Emp selectEmpByNo(int empNo);

    List<Emp> listEmpLikeName(String eName);

    List<Emp> selectManager();
    Page<Emp> listByPage(int currentPage, int pageSize);
}
