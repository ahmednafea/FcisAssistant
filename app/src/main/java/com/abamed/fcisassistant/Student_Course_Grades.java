package com.abamed.fcisassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import FcisAssistant.Adminstration;
import FcisAssistant.Grade;

public class Student_Course_Grades extends AppCompatActivity {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private RecyclerView.Adapter adapter;
   private String CourseName;
   private String []GradesNames;
   private String []CoursesGradesLimits;
   private String []CoursesGrades;
   private Grade Coursegrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__grades);
        Bundle b = getIntent().getExtras();
        CourseName = b != null ? b.getString("Coursename") : null;
        Coursegrade= Adminstration.student.getCourselist().get(Coursesearch(CourseName)).getCourseGrade();
        GradesNames= new String[]{"Midterm", "Final",  "Assignment", "Attendance", "Bounce", "Quizzes", "Practical", "Weight","Total Grade", "GPA"};
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
        adapter = new CourseGradesAdapter(GradesNames,CoursesGradesLimits,CoursesGrades);
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent =new Intent(Student_Course_Grades.this ,StudentNavigation.class);
        this.finish();
        startActivity(intent);
    }
public int Coursesearch(String CourseName){
        for (int i=0;i<Adminstration.student.getCourselist().size();i++){
            if(Adminstration.student.getCourselist().get(i).getName().equals(CourseName))
                return i;
        }
        return -1;
}

    class CourseGradesAdapter extends RecyclerView.Adapter<CourseGradesAdapter.ViewHolder>{
        private String []GradesNames;
        private String []CoursesGradesLimits;
        private String []CoursesGrades;
        CourseGradesAdapter(String [] gradesNames,String[]coursesGradesLimits,String[]coursesGrades) {
       GradesNames=gradesNames;
       CoursesGradesLimits=coursesGradesLimits;
       CoursesGrades=coursesGrades;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView Gradename,Gradelimit,grade;
            ViewHolder(View itemView) {
                super(itemView);
                Gradename=(TextView)itemView.findViewById(R.id.gradename);
                Gradelimit = (TextView)itemView.findViewById(R.id.gradelimit);
                grade=(TextView)itemView.findViewById(R.id.grade);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int position = getAdapterPosition();
                        Snackbar.make(v, "Click detected on Grad " + Gradename.getText().toString(),
                                Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.coursecard, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.Gradename.setText(GradesNames[i]);
            viewHolder.Gradelimit.setText(CoursesGradesLimits[i]);
            viewHolder.grade.setText(CoursesGrades[i]);
        }

        @Override
        public int getItemCount() {
            return GradesNames.length;
        }
    }
}
