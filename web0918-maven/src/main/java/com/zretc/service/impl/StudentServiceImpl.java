package com.zretc.service.impl;

import com.zretc.dao.StudentDao;
import com.zretc.dao.impl.StudentDaoImpl;
import com.zretc.entity.Student;
import com.zretc.service.StudentService;

import java.util.List;

public class  StudentServiceImpl implements StudentService {
    StudentDao sd=new StudentDaoImpl();
    @Override
    public List<Student> listStudent() {
        return sd.listStudent();
    }

    @Override
    public Student selectStudentByNo(String studentNo) {
        return sd.selectStudentByNo(studentNo);
    }

    @Override
    public boolean addStudent(Student student) {
        return sd.addStudent(student);
    }

    @Override
    public boolean deleteStudentByNo(String studentNo) {
        return sd.deleteStudentByNo(studentNo);
    }

    @Override
    public boolean updateStudentByNo(Student student) {
        return sd.updateStudentByNo(student);
    }
}
