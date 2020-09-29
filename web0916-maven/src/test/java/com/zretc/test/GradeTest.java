package com.zretc.test;

import com.zretc.entity.Grade;
import com.zretc.service.GradeService;
import com.zretc.service.impl.GradeServiceImpl;
import org.junit.Test;

import java.util.List;

public class GradeTest {
    GradeService gs=new GradeServiceImpl();
    //查询所有班级
    @Test
    public void listTest(){
        List<Grade> list=gs.listGrade();
        list.forEach(System.out::println);
    }
    //根据id查询
    @Test
    public void SelectGradeByNoTest(){
        Grade grade=gs.selectGradeByNo(1);
        System.out.println(grade);
    }
    //添加
    @Test
    public void AddGrade(){
        Grade grade=new Grade(5,"班级5");
        System.out.println(gs.addGrade(grade));
    }
    //根据id删除
    @Test
    public void DeleteGradeByNoTest(){
        System.out.println(gs.deleteGradeByNo(5));
    }
    //修改
    @Test
    public void UpdateGrade(){
        Grade grade=new Grade(5,"班级五");
        System.out.println(gs.updateGradeByNo(grade));
    }
}