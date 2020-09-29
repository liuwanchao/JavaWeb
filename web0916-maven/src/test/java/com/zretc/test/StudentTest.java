package com.zretc.test;

import com.zretc.entity.Student;
import com.zretc.service.StudentService;
import com.zretc.service.impl.StudentServiceImpl;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class StudentTest {
    StudentService ss=new StudentServiceImpl();

    //查询所有学生
    @Test
    public void ListTest(){
        List<Student> list=ss.listStudent();
        list.forEach(System.out::println);
    }
    //根据id查询学生
    @Test
    public void SelectStudentByNoTest(){
        Student student=ss.selectStudentByNo("s101");
        System.out.println(student);
    }
    //添加学生
    @Test
    public void AddStudent(){
        Student student=new Student("s104","赵六","123","男",new Date(),"123432422","天津市",164,2);
        System.out.println(ss.addStudent(student));
    }
    //根据id删除学生
    @Test
    public void DeleteStudentByNoTest(){
        System.out.println(ss.deleteStudentByNo("s104"));
    }
    //修改学生
    @Test
    public void UpdateStudent(){
        Student student=new Student("s104","赵六1","1231","男",new Date(),"1555522","山东省",164,2);
        System.out.println(ss.updateStudentByNo(student));
    }
}
