package com.abamed.fcisassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class StudentGradeEditable extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []GradesNames;
    String []CoursesGradesLimits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_grade_editable);
        GradesNames= new String[]{"Midterm", "Final"};
        CoursesGradesLimits=new String[]{"/20","/50"};
        recyclerView =(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CourseGradesAdapter(GradesNames,CoursesGradesLimits);
        recyclerView.setAdapter(adapter);

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
        }

        @Override
        public int getItemCount() {
            return GradesNames.length;
        }
    }
}
