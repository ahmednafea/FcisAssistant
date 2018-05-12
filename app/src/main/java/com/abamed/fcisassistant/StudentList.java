package com.abamed.fcisassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import FcisAssistant.Adminstration;

public class StudentList extends AppCompatActivity {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private RecyclerView.Adapter adapter;
    String []Students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        Students=new String[]{"Ahmed nafea","Mohamed"};
        recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ContentAdapter(Students);
        recyclerView.setAdapter(adapter);
    }
   /* public int Coursesearch(String CourseName){
        for (int i=0;i<Adminstration.instructor.getCourselist().size();i++){
            if(Adminstration.student.getCourselist().get(i).getName().equals(CourseName))
                return i;
        }
        return -1;
    }
*/
    class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        String[]Students;

        ContentAdapter(String [] students) {
            Students=students;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView Studentname;
            ViewHolder(View itemView) {
                super(itemView);
                Studentname=itemView.findViewById(R.id.studentname);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        Intent intent = new Intent(StudentList.this, StudentGradeEditable.class);
                        startActivity(intent);
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.studentcard, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.Studentname.setText(Students[i]);
        }

        @Override
        public int getItemCount() {
            return Students.length;
        }
    }
}
