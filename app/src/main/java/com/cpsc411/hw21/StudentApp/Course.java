package com.cpsc411.hw21.StudentApp;

public class Course {
    protected String mCourseId;
    protected String mGrade;

    public Course(String courseId, String grade){
        mCourseId = courseId;
        mGrade = grade;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public void setCourseId(String mCourseId) {
        this.mCourseId = mCourseId;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String mGrade) {
        this.mGrade = mGrade;
    }
}
