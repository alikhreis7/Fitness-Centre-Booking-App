package com.example.seg2105_finalproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClassesTest {

    @Test
    public void setID() {
        Classes id = new Classes("12");
        assertEquals("12",id.setID());

    }

    @Test
    public void getID() {
        Classes id = new Classes("12");
        assertEquals("12",id.getID());
    }

    @Test
    public void setClassesName() {
    }

    @Test
    public void getClassesName() {
    }

    @Test
    public void setTime() {
    }

    @Test
    public void getTime() {
    }
}
public class Classes {
    private int _id;
    private String _Classesname;
    private double _Time;

    public Classes() {
    }
    public Classes(int id, String classesname, double time) {
        _id = id;

        _Classesname = classesname;
        _Time = time;
    }
    public Classes(String classesname, double time) {
        _Classesname = classesname;
        _Time = time;
    }

    public void setID(int id) {
        _id = id;
    }
    public int getID() {
        return _id;
    }
    public void setClassesName(String classesname) {
        _Classesname = classesname;
    }
    public String getClassesName() {
        return _Classesname;
    }
    public void setTime(double time) {
        _Time = time;
    }
    public double getTime() {
        return _Time;
    }
}