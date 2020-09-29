package com.zretc.service.impl;

import com.zretc.dao.GradeDao;
import com.zretc.dao.impl.GradeDaoImpl;
import com.zretc.entity.Grade;
import com.zretc.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {
    GradeDao gd=new GradeDaoImpl();
    @Override
    public List<Grade> listGrade() {
        return gd.listGrade();
    }

    @Override
    public Grade selectGradeByNo(int gradeId) {
        return gd.selectGradeByNo(gradeId);
    }

    @Override
    public boolean addGrade(Grade grade) {
        return gd.addGrade(grade);
    }

    @Override
    public boolean deleteGradeByNo(int gradeId) {
        return gd.deleteGradeByNo(gradeId);
    }

    @Override
    public boolean updateGradeByNo(Grade grade) {
        return gd.updateGradeByNo(grade);
    }
}
