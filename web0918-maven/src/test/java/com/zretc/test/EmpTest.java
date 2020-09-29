package com.zretc.test;

import com.zretc.service.EmpService;
import com.zretc.service.impl.EmpServiceImpl;
import org.junit.Test;

public class EmpTest {
    EmpService es=new EmpServiceImpl();
    @Test
    public void ss(){
        System.out.println(es.selectEmpByNo(1));
    }
}
