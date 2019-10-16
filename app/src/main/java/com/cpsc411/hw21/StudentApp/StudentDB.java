package com.cpsc411.hw21.StudentApp;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB singleInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    static public StudentDB getInstance(){
        return singleInstance;
    }

    private StudentDB(){}

    public ArrayList<Student> getStudentList(){
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList){
        mStudentList = studentList;
    }
}
