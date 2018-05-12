package com.abamed.fcisassistant;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.Vector;

import FcisAssistant.Adminstration;
import FcisAssistant.FirebaseClass;
import FcisAssistant.Grade;
import FcisAssistant.GradeDistribution;
import FcisAssistant.Instructor;
import FcisAssistant.Student;
import FcisAssistant.StudentCourse;
import FcisAssistant.TeacherAssistant;

public class SignUp extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText IDtext,EMailtext,PAsswordtext;
    int I;
    private Spinner spinner;
    private static final String[]paths = {"Student", "Instructor", "Teacher Assistant"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    Adminstration.student=new Student("20161701018","Bassant_fakhry","female","empty","empty","Second","Bioinformatics",
            88);
        Adminstration.student.InsertCourse();
        Adminstration.instructor=new Instructor();
        Adminstration.TA=new TeacherAssistant();
        Student student=new Student("20161701004","Ahmed_Nafea","Male","empty","empty","Second","Bioinformatics",
        87);
    Student student1=new Student();
    FirebaseClass.AddStudent(student1);

        setContentView(R.layout.activity_sign_up);
        IDtext=(EditText)findViewById(R.id.idbox);
        EMailtext=(EditText)findViewById(R.id.emailbox);
        PAsswordtext=(EditText)findViewById(R.id.passwordbox);
        spinner = (Spinner)findViewById(R.id.type);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(SignUp.this,
                android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }
    public void Haveaccountclick(View view){
        Intent intent =new Intent(SignUp.this ,SignIn.class);
        SignUp.this.finish();
        startActivity(intent);
    }
    public void signup(View view){

        //final AlertDialog.Builder Result= new AlertDialog.Builder(this);
        if(I==0) {
         //  if (FirebaseClass.ChickStudentID(IDtext.getText().toString().trim())){
              // if(!FirebaseClass.ChickStudentEmailandPassword(IDtext.getText().toString().trim())){
               /* FirebaseClass.AddUser(IDtext.getText().toString().trim(),
                       EMailtext.getText().toString().trim(),
                       PAsswordtext.getText().toString().trim());
                Adminstration.student=FirebaseClass.GetStudentInfo(IDtext.getText().toString().trim());
                */Intent intent =new Intent(SignUp.this ,StudentNavigation.class);
                SignUp.this.finish();
                startActivity(intent);

               /*}
               else {
                   Toast.makeText(this,"You already have an account please login",Toast.LENGTH_LONG).show();
               }*/
           //}
          // else {
             //  Toast.makeText(this,"Check Your ID please !!",Toast.LENGTH_SHORT).show();
           //}
        }
        else if(I==1){
            Intent intent =new Intent(SignUp.this ,InstructorNavigation.class);
            SignUp.this.finish();
            startActivity(intent);
        }
        else if(I==2){
            Intent intent =new Intent(SignUp.this ,TANavigation.class);
            SignUp.this.finish();
            startActivity(intent);

        }
        else {
            Toast.makeText(getApplicationContext(),"Check your data please !!",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                I=0;
                break;
            case 1:
                I=1;
                break;
            case 2:
                I=2;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
