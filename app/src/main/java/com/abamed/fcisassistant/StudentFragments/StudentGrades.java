package com.abamed.fcisassistant.StudentFragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.Course_Grades;
import com.abamed.fcisassistant.Grades_Charts;
import com.abamed.fcisassistant.R;
import com.abamed.fcisassistant.SignIn;
import com.abamed.fcisassistant.SignUp;
import com.abamed.fcisassistant.StudentNavigation;

import java.util.ArrayList;

import FcisAssistant.Adminstration;
import FcisAssistant.StudentCourse;


public class StudentGrades extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []Courses;
    int [] Images;
    public StudentGrades() {
        // Required empty public constructor
    }
    public static StudentGrades newInstance(String param1, String param2) {
        StudentGrades fragment = new StudentGrades();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student_grades, container, false);
        Courses= new String[]{"OOP", "Logic"};
        Images= new int[]{R.drawable.ana,R.drawable.ana};
        recyclerView =view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new StudentGrades.GradesAdapter(Courses,Images);
        recyclerView.setAdapter(adapter);
        return view;
    }
    class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.ViewHolder> {
        private String[] Courses ;
        private int [] images ;

        GradesAdapter(String[] titles, int[] images) {
            this.Courses = titles;
            this.images = images;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView itemImage;
            TextView itemTitle;
            ViewHolder(View itemView) {
                super(itemView);
                itemImage = (ImageView)itemView.findViewById(R.id.courseimage);
                itemTitle = (TextView)itemView.findViewById(R.id.coursename);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Course_Grades.class);
                        //intent.putExtra("Coursename",itemTitle.getText().toString());
                        startActivity(intent);
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
            viewHolder.itemTitle.setText(Courses[i]);
            viewHolder.itemImage.setImageResource(R.drawable.material);
        }

        @Override
        public int getItemCount() {
            return Courses.length;
        }
    }
}
