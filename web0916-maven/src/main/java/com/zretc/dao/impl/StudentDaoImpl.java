package com.zretc.dao.impl;

import com.zretc.dao.StudentDao;
import com.zretc.entity.Student;
import com.zretc.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> listStudent() {
        List<Student> list=new ArrayList<>();
        String sql="select * from student";
        ResultSet rs=DBUtil.exQuery(sql);
        try {
            while (rs.next()){
                Student stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getInt(9));
                list.add(stu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return list;
    }

    @Override
    public Student selectStudentByNo(String studentNo) {
        String sql="select * from student where student_no=?";
        ResultSet rs=DBUtil.exQuery(sql,studentNo);
        Student stu=new Student();
        try {
            if(rs.next()){
                stu=new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getInt(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close();
        return stu;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql="insert into student values(?,?,?,?,?,?,?,?,?)";
        int n=DBUtil.exUpdate(sql,student.getStudentNo(),student.getStudentName(),student.getStudentPwd(),student.getStudentGender(),student.getStudentBorndate(),student.getStudentContact(),student.getStudentAddress(),student.getStudentWeight(),student.getGradeId());
        return n>0;
    }

    @Override
    public boolean deleteStudentByNo(String studentNo) {
        String sql="delete from student where student_no=?";
        int n=DBUtil.exUpdate(sql,studentNo);
        return n>0;
    }

    @Override
    public boolean updateStudentByNo(Student student) {
        String sql="update student set student_name=? where student_no=?";
        int n=DBUtil.exUpdate(sql,student.getStudentName(),student.getStudentNo());
        return n>0;
    }
}
