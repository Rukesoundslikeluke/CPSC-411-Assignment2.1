package com.cpsc411.hw21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.cpsc411.hw21.StudentApp.Course;
import com.cpsc411.hw21.StudentApp.Student;
import com.cpsc411.hw21.StudentApp.StudentDB;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createStudentObjects();
        setContentView(R.layout.student_list);


        setContentView(R.layout.activity_main);
    }

    protected void createStudentObjects(){
        ArrayList<Student> students = new ArrayList<Student>();

        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC121-02","A"));
        courses.add(new Course("MATH150A-09", "B+"));
        Student student = new Student("Michael","Rodriguez","185020329",courses);
        students.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC131-01","C"));
        courses.add(new Course("CPSC353-05","F"));
        student = new Student("John","Smith","313152870",courses);
        students.add(student);

        courses = new ArrayList<Course>();
        courses.add(new Course("CPSC131-01","A"));
        courses.add(new Course("CPSC353-05","C"));
        student = new Student("Jane","Doe","292172108",courses);
        students.add(student);

        StudentDB.getInstance().setStudentList(students);
    }
}
