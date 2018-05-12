package com.abamed.fcisassistant.TAFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.InstructorFragments.InstructorContent;
import com.abamed.fcisassistant.R;

import java.util.ArrayList;

import FcisAssistant.Adminstration;
import FcisAssistant.InstructorCourse;
import FcisAssistant.TACourse;


public class TAContent extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String []CourseName;
    int [] Images;
    public TAContent() {
        // Required empty public constructor
    }
    public static TAContent newInstance(String param1, String param2) {
        TAContent fragment = new TAContent();
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
        View view = inflater.inflate(R.layout.fragment_tacontent, container, false);
        CourseName= new String[]{"OOP", "Logic"};
        Images= new int[]{R.drawable.profile,R.drawable.profile};
        recyclerView =view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ContentAdapter(CourseName,Images);
        recyclerView.setAdapter(adapter);
        return view;
    }
    class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        private String[] Coursesnames ;
        private int [] Coursesimages ;

        ContentAdapter(String[] coursesnames, int[] coursesimages) {
            Coursesnames = coursesnames;
            Coursesimages = coursesimages;
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
                        int position = getAdapterPosition();
                        Snackbar.make(v, "Sorry this Function will be added in the next edition " + position,
                                Snackbar.LENGTH_LONG)
                                .setAction("Alert", null).show();
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
            viewHolder.itemTitle.setText(Coursesnames[i]);
            viewHolder.itemImage.setImageResource(Coursesimages[i]);
        }

        @Override
        public int getItemCount() {
            return Coursesnames.length;
        }
    }
}
