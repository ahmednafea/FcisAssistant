package com.abamed.fcisassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import FcisAssistant.Adminstration;
import FcisAssistant.Grade;

public class Course_Grades extends AppCompatActivity {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private RecyclerView.Adapter adapter;
   private String []GradesNames;
   private String []CoursesGradesLimits;
   private String []CoursesGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__grades);
      //  Bundle b = getIntent().getExtras();
        //CourseName = b != null ? b.getString("Coursename") : null;
        //Coursegrade= Adminstration.student.getCourselist().get(Coursesearch(CourseName)).getCourseGrade();
        GradesNames= new String[]{"Midterm", "Final",  "Assignment", "Attendance", "Bounce", "Quizzes", "Practical", "Weight","Total Grade", "GPA"};
        CoursesGradesLimits=new String[]{"15","50","10","5","10","20","4","100"};
        CoursesGrades=new String[]{"10","40","9","5","8","18","3","90"};
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
        this.finish();
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
                        Snackbar.make(v, "Click detected on item " + position,
                                Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.gradecard, viewGroup, false);
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
