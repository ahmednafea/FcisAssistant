package com.abamed.fcisassistant.TAFragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.abamed.fcisassistant.Course_Grades;
import com.abamed.fcisassistant.Grades_Charts;
import com.abamed.fcisassistant.InstructorFragments.InstructorDiscussion;
import com.abamed.fcisassistant.PostPanel;
import com.abamed.fcisassistant.R;

import java.util.ArrayList;

import FcisAssistant.Adminstration;
import FcisAssistant.FirebaseClass;
import FcisAssistant.Post;

public class TADiscussion extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    Button newpost;
    String []Posters;
    String []Posts;
    int [] Images;
    public TADiscussion() {
        // Required empty public constructor
    }
    public static TADiscussion newInstance(String param1, String param2) {
        TADiscussion fragment = new TADiscussion();
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
        View view = inflater.inflate(R.layout.fragment_tadiscussion, container, false);
        Posters= new String[]{"Islam Hegazy", "Manal Tantawy"};
        Posts=new String[]{"البروجيكتات هتتسلم بكرة","يا سنة تانية درجاتكم زى الزفت"};
        Images= new int[]{R.drawable.ana,R.drawable.ana};
        newpost=view.findViewById(R.id.newpostbtn);
        recyclerView =view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new DiscussionsAdapter(Posters,Posts,Images);
        recyclerView.setAdapter(adapter);
        newpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PostPanel.class);
                intent.putExtra(Adminstration.instructor.getName(),"postername");
                startActivity(intent);
            }
        });
        return view;
    }
    class DiscussionsAdapter extends RecyclerView.Adapter<DiscussionsAdapter.ViewHolder> {

        private String[] titles ;

        private String[] details ;

        private int [] images ;

        DiscussionsAdapter(String[] titles, String[] details, int[] images) {
            this.titles = titles;
            this.details = details;
            this.images = images;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            ImageView PosterImage;
            TextView PosterName, PostContent, PostTime;
            ViewHolder(View itemView) {
                super(itemView);
                PosterImage = (ImageView)itemView.findViewById(R.id.posterimage);
                PosterName = (TextView)itemView.findViewById(R.id.postername);
                PostContent = (TextView)itemView.findViewById(R.id.postcontent);
                PostTime=(TextView)itemView.findViewById(R.id.posttime);
               /* itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), Grades_Charts.class);
                        startActivity(intent);

                    }
                });*/
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.discussionpost, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.PosterName.setText(titles[i]);
            viewHolder.PostContent.setText(details[i]);
            viewHolder.PosterImage.setImageResource(images[i]);
            viewHolder.PostTime.setText("00:00 am");
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }
}
