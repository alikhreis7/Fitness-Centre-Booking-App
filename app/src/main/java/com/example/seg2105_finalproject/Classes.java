package com.example.seg2105_finalproject;

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
