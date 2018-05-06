package com.abamed.fcisassistant.InstructorFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.abamed.fcisassistant.R;

import FcisAssistant.Instructor;
import de.hdodenhof.circleimageview.CircleImageView;

public class InstructorProfile extends Fragment {
    CircleImageView circleImageView;
    RatingBar rb ;
    TextView value,Name,Email,officehours;
    Instructor instructor;
    public InstructorProfile() {
        // Required empty public constructor
    }

    public static InstructorProfile newInstance(String param1, String param2) {
        InstructorProfile fragment = new InstructorProfile();
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
        View view = inflater.inflate(R.layout.fragment_instructor_profile, container, false);
//        instructor=new Instructor((long) 25142,"Islam hegazy","Male","2:4 pm","email20","11111");
        rb=view.findViewById(R.id.ratingBar);
        value=view.findViewById(R.id.value);
        officehours=view.findViewById(R.id.officehours);
        Name=view.findViewById(R.id.instructorname);
        Email=view.findViewById(R.id.instructoremail);
        circleImageView = view.findViewById(R.id.instructorimage);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Value is " + rating);
            }
        });
        Name.setText(instructor.getName());
        Email.setText(instructor.getEmail());
        officehours.setText(instructor.getOfficeHours());
        circleImageView.setImageResource(instructor.getImage());
        return view;
    }
}
