package com.abamed.fcisassistant;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;

import FcisAssistant.Adminstration;
import FcisAssistant.Course;
import FcisAssistant.GPA;
import FcisAssistant.Student;

public class Grades_Charts extends AppCompatActivity {
    private ArrayList<GPA> CourseGradesPercentage;
    private  PieChart chart;
    private String CourseName;
   /* public Grades_Charts(float [] courseGradesPercentage,String [] gpaNames, Course course) {
    CourseGradesPercentage=courseGradesPercentage;
    GPANames=gpaNames;
    this.course=course;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades__charts);
        Bundle B = getIntent().getExtras();
        CourseName = B != null ? B.getString("Coursename") : null;
        chart = (PieChart) findViewById(R.id.gradeschart);
        CourseGradesPercentage= Adminstration.instructor.getCourselist().get(Coursesearch(CourseName)).getGradesPercentage();
        Description description=new Description();
        description.setText("This is "+CourseName+"grades charts");
        chart.setDescription(description);
        chart.setRotationEnabled(true);
        chart.setHoleRadius(30f);
        chart.setTransparentCircleAlpha(0);
        chart.setCenterText(CourseName+" Grades");
        chart.setCenterTextSize(16);
        addsetchart(chart);
        chart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                Log.d("Grades", "onValueSelected: Value select from chart.");
                Log.d("Grades", "onValueSelected: " + e.toString());
                Log.d("Grades", "onValueSelected: " + h.toString());

                int pos1 = e.toString().indexOf("(sum): ");
                String num = e.toString().substring(pos1 + 7);

                for(int i = 0; i < CourseGradesPercentage.size(); i++){
                    if(CourseGradesPercentage.get(i).getCount() == Float.parseFloat(num)){
                        pos1 = i;
                        break;
                    }
                }
                String GRADE = CourseGradesPercentage.get(pos1 + 1).getSymbol();
                Toast.makeText(Grades_Charts.this,  GRADE + "\n" + String.valueOf(CourseGradesPercentage.get(pos1+1)) + num + " Students", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


    }
    public int Coursesearch(String CourseName){
        for (int i=0;i<Adminstration.instructor.getCourselist().size();i++){
            if(Adminstration.student.getCourselist().get(i).getName().equals(CourseName))
                return i;
        }
        return -1;
    }
    public void addsetchart(PieChart pieChart){
        ArrayList<PieEntry> Yentry=new ArrayList<>();
        for (int i=0;i<CourseGradesPercentage.size();i++){
            Yentry.add(new PieEntry(CourseGradesPercentage.get(i).getCount(),i));
        }
        ArrayList<GPA> Xentry = CourseGradesPercentage;
        PieDataSet pieDataSet=new PieDataSet(Yentry,"Grade");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(16);
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
    public void cls(View view){
        Grades_Charts.this.finish();
    }
    public void setCourseGradesPercentage(ArrayList<GPA> courseGradesPercentage) {
        CourseGradesPercentage = courseGradesPercentage;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
