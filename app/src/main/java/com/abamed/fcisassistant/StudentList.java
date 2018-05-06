package com.abamed.fcisassistant;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StudentList extends AppCompatActivity {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private RecyclerView.Adapter adapter;
   private String [] StudentsNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        StudentsNames = new String[]{"Ahmed Nafea Mohamed", "Doaa Husien El badawy"};
        recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ContentAdapter(StudentsNames);
        recyclerView.setAdapter(adapter);
    }
    class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.ViewHolder> {

        private String[] StudentsNames;

        ContentAdapter(String[] titles) {
            this.StudentsNames = titles;
        }
        class ViewHolder extends RecyclerView.ViewHolder{
            TextView StudentName;
            ViewHolder(View itemView) {
                super(itemView);
                StudentName = (TextView)itemView.findViewById(R.id.studentname);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View v) {
                        int position = getAdapterPosition();
                        Snackbar.make(v, "Click detected on item " + position,
                                Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
            }
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.studentgradecard, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.StudentName.setText(StudentsNames[i]);
        }

        @Override
        public int getItemCount() {
            return StudentsNames.length;
        }
    }
}
