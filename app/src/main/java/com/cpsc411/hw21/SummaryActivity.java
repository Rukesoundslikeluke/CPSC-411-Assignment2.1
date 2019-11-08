package com.cpsc411.hw21;
//Michael Rodriguez
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc411.hw21.StudentApp.Course;
import com.cpsc411.hw21.StudentApp.SLAdapter;
import com.cpsc411.hw21.StudentApp.Student;
import com.cpsc411.hw21.StudentApp.StudentDB;

import java.util.ArrayList;

public class SummaryActivity extends AppCompatActivity {

    protected ListView mSummaryView;
    protected Menu addMenu;
    protected SLAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_list_lview);
        createStudentObjects();
        mSummaryView = findViewById(R.id.summary_list_id);
        adapter = new SLAdapter();
        mSummaryView.setAdapter(adapter);

    }

    @Override
    protected void onStart(){
        adapter.notifyDataSetChanged();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.findItem(R.id.action_Add).setVisible(true);
        addMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.action_Add){
            Intent intent = new Intent(this,AddActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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