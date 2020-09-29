package com.zretc.dao;

import com.zretc.entity.Student;

import java.util.List;

public interface StudentDao {

    //查询全部学生
    List<Student> listStudent();
    //根据id查询学生信息
    Student selectStudentByNo(String studentNo);
    //添加学生
    boolean addStudent(Student student);
    //根据编号删除学生
    boolean deleteStudentByNo(String studentNo);
    //根据ID修改学生信息
    boolean updateStudentByNo(Student student);

}
