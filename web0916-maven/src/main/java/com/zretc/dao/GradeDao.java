package com.zretc.dao;

import com.zretc.entity.Grade;

import java.util.List;

public interface GradeDao {
    //查询全部班级
    List<Grade> listGrade();
    //根据id查询
    Grade selectGradeByNo(int gradeId);
    //添加
    boolean addGrade(Grade grade);
    //根据编号删除
    boolean deleteGradeByNo(int gradeId);
    //根据ID修改
    boolean updateGradeByNo(Grade grade);
}
