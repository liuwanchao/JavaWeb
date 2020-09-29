package com.zretc.entity;

public class Stu {
    private int id;
    private Stu stu;

    public Stu() {
    }

    public Stu(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stu getStu() {
        return stu;
    }

    public void setStu(Stu stu) {
        this.stu = stu;
    }
}
