package com.abamed.fcisassistant.TAFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.abamed.fcisassistant.R;

import FcisAssistant.Adminstration;
import FcisAssistant.TeacherAssistant;
import de.hdodenhof.circleimageview.CircleImageView;

public class TAProfile extends Fragment {

    CircleImageView circleImageView;
    RatingBar rb ;
    TextView value,Name,Email,officehours;
    public TAProfile() {
        // Required empty public constructor
    }

    public static TAProfile newInstance(String param1, String param2) {
        TAProfile fragment = new TAProfile();
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
        View view = inflater.inflate(R.layout.fragment_taprofile, container, false);
        rb=view.findViewById(R.id.ratingBar);
        value=view.findViewById(R.id.value);
        Name=view.findViewById(R.id.taname);
        Email=view.findViewById(R.id.taemail);
        circleImageView = view.findViewById(R.id.taimage);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value.setText("Value is " + rating);
            }
        });
        Name.setText("Rafy");
        Email.setText("rafy@gmail.com");
        officehours.setText("0");
        circleImageView.setImageResource(R.drawable.profile);
        return view;
    }
}
