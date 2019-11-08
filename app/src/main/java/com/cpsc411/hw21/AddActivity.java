package com.cpsc411.hw21;
//Michael Rodriguez
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cpsc411.hw21.StudentApp.Course;
import com.cpsc411.hw21.StudentApp.Student;
import com.cpsc411.hw21.StudentApp.StudentDB;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    protected Menu addMenu;
    ArrayList<Course> courses = new ArrayList<Course>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final GridLayout g = findViewById(R.id.course_grid);
        g.setBackgroundResource(R.drawable.thin_border);

        Button addButton = findViewById(R.id.add_course);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText courseID = new EditText(view.getContext());
                courseID.setSingleLine();
                courseID.setTextSize(14);
                g.addView(courseID);

                EditText courseGrade = new EditText(view.getContext());
                courseGrade.setSingleLine();;
                courseGrade.setTextSize(14);
                g.addView(courseGrade);
                courses.add(new Course(courseID.getText().toString(), courseGrade.getText().toString()));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.add_menu,menu);
        menu.findItem(R.id.action_Done).setVisible(true);
        addMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    //When done option is pressed we will send all the filled values to the db
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.action_Done){
            TextView f = findViewById(R.id.first_name_add);
            TextView l = findViewById(R.id.last_name_add);
            TextView c = findViewById(R.id.cwid_add);
            String fname = f.getText().toString();
            String lname = l.getText().toString();
            String cwid = c.getText().toString();

            Log.d("CPSC11", fname + "\n" + lname+ "\n" + cwid+ "\n" + courses.toString());
            if(cwid != "" && fname != "" && lname != ""){
                Student student = new Student(fname,lname,cwid,courses);
                StudentDB.getInstance().addStudent(student);
                Log.d("CPSC11","Ding" );
            }

            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
