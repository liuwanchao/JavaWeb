package com.zretc.entity;

import java.util.Date;

public class Student {
    private String studentNo;
    private String studentName;
    private String studentPwd;
    private String studentGender;
    private Date studentBorndate;
    private String studentContact;
    private String studentAddress;
    private double studentWeight;
    private Integer gradeId;

    public Student() {
    }

    public Student(String studentNo, String studentName, String studentPwd, String studentGender, Date studentBorndate, String studentContact, String studentAddress, double studentWeight, Integer gradeId) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentPwd = studentPwd;
        this.studentGender = studentGender;
        this.studentBorndate = studentBorndate;
        this.studentContact = studentContact;
        this.studentAddress = studentAddress;
        this.studentWeight = studentWeight;
        this.gradeId = gradeId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPwd='" + studentPwd + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentBorndate=" + studentBorndate +
                ", studentContact=" + studentContact + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentWeight=" + studentWeight +
                ", gradeId=" + gradeId +
                '}';
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentBorndate() {
        return studentBorndate;
    }

    public void setStudentBorndate(Date studentBorndate) {
        this.studentBorndate = studentBorndate;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public double getStudentWeight() {
        return studentWeight;
    }

    public void setStudentWeight(double studentWeight) {
        this.studentWeight = studentWeight;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }
}
