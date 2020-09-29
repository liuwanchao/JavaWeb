package com.zretc.dao.impl;

import com.zretc.dao.GradeDao;
import com.zretc.entity.Grade;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    @Override
    public List<Grade> listGrade() {
        List<Grade> list = new ArrayList<>();
        String sql = "select * from grade";
        ResultSet rs = DBUtil.exQuery(sql);
        try {
            while (rs.next()) {
                Grade grade = new Grade(rs.getInt(1), rs.getString(2));
                list.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Grade selectGradeByNo(int gradeId) {
        Grade grade=new Grade();
        String sql = "select * from grade where grade_id=?";
        ResultSet rs = DBUtil.exQuery(sql,gradeId);
        try {
            if (rs.next()) {
                grade = new Grade(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return grade;
    }

    @Override
    public boolean addGrade(Grade grade) {
        String sql = "insert into grade values(?,?)";
        int n=DBUtil.exUpdate(sql,grade.getGradeId(),grade.getGradeName());
        return n>0;
    }

    @Override
    public boolean deleteGradeByNo(int gradeId) {
        String sql = "delete from grade where grade_id=?";
        int n=DBUtil.exUpdate(sql,gradeId);
        return n>0;
    }

    @Override
    public boolean updateGradeByNo(Grade grade) {
        String sql = "update grade set grade_name=? where grade_id=?";
        int n=DBUtil.exUpdate(sql,grade.getGradeName(),grade.getGradeId());
        return n>0;
    }
}
