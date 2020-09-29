package com.zretc.entity;

public class Emp {
    private int eid;
    private String ename;
    private int salary;
    private int deptid;

    public Emp() {
    }

    public Emp(int eid, String ename, int salary, int deptid) {
        this.eid = eid;
        this.ename = ename;
        this.salary = salary;
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                ", deptid=" + deptid +
                '}';
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }
}
