package com.abamed.fcisassistant.TAFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.Course_Grades;
import com.abamed.fcisassistant.InstructorFragments.InstructorGrades;
import com.abamed.fcisassistant.R;

public class TAGrades extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []Courses;
    int [] Images;
    public TAGrades() {
        // Required empty public constructor
    }
    public static TAGrades newInstance(String param1, String param2) {
        TAGrades fragment = new TAGrades();
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
        View view = inflater.inflate(R.layout.fragment_tagrades, container, false);
        Courses= new String[]{"OOP", "Logic"};
        Images= new int[]{R.drawable.ana,R.drawable.ana};
        recyclerView =view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new Grades_Adapter(Courses,Images);
        recyclerView.setAdapter(adapter);
        return view;
    }
    class Grades_Adapter extends RecyclerView.Adapter<Grades_Adapter.ViewHolder> {

        private String[] Courses ;
        private int [] images ;

        Grades_Adapter(String[] titles, int[] images) {
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
                        Course_Grades course_grades=new Course_Grades();
                        startActivity(course_grades.getIntent());
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
            viewHolder.itemImage.setImageResource(images[i]);
        }

        @Override
        public int getItemCount() {
            return Courses.length;
        }
    }
}
