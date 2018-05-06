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

import FcisAssistant.Course;
import FcisAssistant.Student;

public class Grades_Charts extends AppCompatActivity {
    private float[] CourseGradesPercentage;
    private String[] GPANames;
    private  PieChart chart;
    private Course course;
   /* public Grades_Charts(float [] courseGradesPercentage,String [] gpaNames, Course course) {
    CourseGradesPercentage=courseGradesPercentage;
    GPANames=gpaNames;
    this.course=course;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades__charts);
        chart = (PieChart) findViewById(R.id.gradeschart);
        GPANames= new String[]{"C", "A", "A-", "B+"};
        CourseGradesPercentage=new float[]{25f,5f,15f,55f};
        Description description=new Description();
        description.setText("This is "+"OOP "+"grades charts");
        chart.setDescription(description);
        chart.setRotationEnabled(true);
        chart.setHoleRadius(30f);
        chart.setTransparentCircleAlpha(0);
        chart.setCenterText("OOP "+" Grades");
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

                for(int i = 0; i < CourseGradesPercentage.length; i++){
                    if(CourseGradesPercentage[i] == Float.parseFloat(num)){
                        pos1 = i;
                        break;
                    }
                }
                String GRADE = GPANames[pos1 + 1];
                Toast.makeText(Grades_Charts.this, "GPA" + GRADE + "\n" + "No of Students : " + num + " Students", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });


    }
    public void addsetchart(PieChart pieChart){
        ArrayList<PieEntry> Yentry=new ArrayList<>();
        for (int i=0;i<CourseGradesPercentage.length;i++){
            Yentry.add(new PieEntry(CourseGradesPercentage[i],i));
        }
        ArrayList<String> Xentry = new ArrayList<>(Arrays.asList(GPANames));
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
    public void setCourseGradesPercentage(float[] courseGradesPercentage) {
        CourseGradesPercentage = courseGradesPercentage;
    }
}
