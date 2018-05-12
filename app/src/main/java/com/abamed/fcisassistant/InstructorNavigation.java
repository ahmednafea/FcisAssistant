package com.abamed.fcisassistant;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.abamed.fcisassistant.InstructorFragments.InstructorContent;
import com.abamed.fcisassistant.InstructorFragments.InstructorDiscussion;
import com.abamed.fcisassistant.InstructorFragments.InstructorGrades;
import com.abamed.fcisassistant.InstructorFragments.InstructorProfile;

public class InstructorNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor_navigation);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.instructor_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new TopNavigationBehavior());
        loadFragment(new InstructorGrades());

    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()  {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.instructor_navigation_grades:
                    fragment = new InstructorGrades();
                    loadFragment(fragment);
                    return true;
                case R.id.instructor_navigation_content:
                    fragment = new InstructorContent();
                    loadFragment(fragment);
                    return true;
                case R.id.instructor_navigation_discussion:
                    fragment = new InstructorDiscussion();
                    loadFragment(fragment);
                    return true;
                case R.id.instructor_navigation_profile:
                    fragment = new InstructorProfile();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.instructor_frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
