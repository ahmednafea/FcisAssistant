package com.abamed.fcisassistant;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.abamed.fcisassistant.StudentFragments.StudentContent;
import com.abamed.fcisassistant.StudentFragments.StudentDiscussion;
import com.abamed.fcisassistant.StudentFragments.StudentGrades;
import com.abamed.fcisassistant.StudentFragments.StudentTable;

public class StudentNavigation extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_navigation);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.student_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new TopNavigationBehavior());
        loadFragment(new StudentGrades());
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()  {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.student_navigation_grades:
                    fragment = new StudentGrades();
                    loadFragment(fragment);
                    return true;
                case R.id.student_navigation_content:
                    fragment = new StudentContent();
                    loadFragment(fragment);
                    return true;
                case R.id.student_navigation_discussion:
                    fragment = new StudentDiscussion();
                    loadFragment(fragment);
                    return true;
                case R.id.student_navigation_table:
                    fragment = new StudentTable();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.student_frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
