package com.abamed.fcisassistant;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import FcisAssistant.Adminstration;
import FcisAssistant.FirebaseClass;
import FcisAssistant.Grade;

public class StudentGradeEditable extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []GradesNames;
    String []CoursesGradesLimits;
    private String []CoursesGrades;
    String StudentId;
    private String CourseName;
    private Grade Coursegrade;
    private Button chartbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade_editable);
        chartbtn=findViewById(R.id.gradeschartbtn);
        Bundle b = getIntent().getExtras();
        StudentId = b != null ? b.getString("StudentId") : null;
        Bundle B = getIntent().getExtras();
        CourseName = B != null ? B.getString("Coursename") : null;
        Adminstration.student= FirebaseClass.GetStudentInfo(StudentId);
        Coursegrade= Adminstration.student.getCourselist().get(Coursesearch(CourseName)).getCourseGrade();
        GradesNames= new String[]{"Midterm", "Final",  "Assignment", "Attendance", "Bounce",
                "Quizzes", "Practical", "Weight","Total Grade", "GPA"};
        CoursesGradesLimits=new String[]{String.valueOf(Coursegrade.getMax().getMaxMidterm()),String.valueOf(Coursegrade.getMax().getMaxFinal())
                ,String.valueOf(Coursegrade.getMax().getMaxAssignment()),String.valueOf(Coursegrade.getMax().getMaxAttendance())
                ,String.valueOf(Coursegrade.getMax().getMaxQuizzes()),String.valueOf(Coursegrade.getMax().getMaxPractical())
                ,String.valueOf(Coursegrade.getMax().getMaxWeight()),"100"};
        Coursegrade.setGPA();
        CoursesGrades=new String[]{String.valueOf(Coursegrade.getMidterm()),String.valueOf(Coursegrade.getFinal()),String.valueOf(Coursegrade.getAssignment())
                ,String.valueOf(Coursegrade.getAttendance()),String.valueOf(Coursegrade.getBounce())
                ,String.valueOf(Coursegrade.getQuizzes()),String.valueOf(Coursegrade.getPractical()),String.valueOf(Coursegrade.getWeight()),String.valueOf(Coursegrade.getTotalGrade())
                ,String.valueOf(Coursegrade.getGPA())};
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CourseGradesAdapter(GradesNames,CoursesGradesLimits);
        recyclerView.setAdapter(adapter);
        chartbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentGradeEditable.this, Grades_Charts.class);
                intent.putExtra("Coursename",CourseName);
                startActivity(intent);
            }
        });

    }
    public int Coursesearch(String CourseName){
        for (int i=0;i<Adminstration.instructor.getCourselist().size();i++){
            if(Adminstration.student.getCourselist().get(i).getName().equals(CourseName))
                return i;
        }
        return -1;
    }
    class CourseGradesAdapter extends RecyclerView.Adapter<CourseGradesAdapter.ViewHolder>{
        String []GradesNames;
        String []CoursesGradesLimits;
        CourseGradesAdapter(String[] gradesNames, String[] coursesGradesLimits) {
            GradesNames=gradesNames;
            CoursesGradesLimits=coursesGradesLimits;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView Gradename,Gradelimit;
            EditText grade;
            ViewHolder(View itemView) {
                super(itemView);
                Gradename=(TextView)itemView.findViewById(R.id.gradename);
                Gradelimit = (TextView)itemView.findViewById(R.id.gradelimit);
                grade=(EditText) itemView.findViewById(R.id.grade);
                grade.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        Adminstration.student.getCourselist().get(Coursesearch(CourseName)).getCourseGrade().Choice(Gradename.getText().toString(),Float.parseFloat(grade.getText().toString()));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.gradecardeditable, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.Gradename.setText(GradesNames[i]);
            viewHolder.Gradelimit.setText(CoursesGradesLimits[i]);
        }

        @Override
        public int getItemCount() {
            return GradesNames.length;
        }
    }
}
