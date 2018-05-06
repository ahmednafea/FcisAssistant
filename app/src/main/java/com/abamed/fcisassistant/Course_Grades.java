package com.abamed.fcisassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.StudentFragments.StudentGrades;

public class Course_Grades extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []GradesNames;
    String []CoursesGradesLimits;
    String []CoursesGrades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course__grades);
        GradesNames= new String[]{"Midterm", "Final"};
        CoursesGradesLimits=new String[]{"/20","/50"};
        CoursesGrades=new String[]{"15","40"};
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CourseGradesAdapter(GradesNames,CoursesGradesLimits,CoursesGrades);
        recyclerView.setAdapter(adapter);

    }
    class CourseGradesAdapter extends RecyclerView.Adapter<CourseGradesAdapter.ViewHolder>{
        String []GradesNames;
        String []CoursesGradesLimits;
        String []CoursesGrades;
        CourseGradesAdapter(String[] gradesNames, String[] coursesGradesLimits,String[]coursesGrades) {
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
