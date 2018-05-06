package com.abamed.fcisassistant.StudentFragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abamed.fcisassistant.R;
import com.abamed.fcisassistant.Tableclass;

import java.util.ArrayList;
import java.util.List;


public class StudentTable extends Fragment {

    private RecyclerView recyclerView;
    private List<Tableclass> Lectures;
    private TableAdapter mAdapter;

    public static StudentTable newInstance(String param1, String param2) {
        StudentTable fragment = new StudentTable();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public StudentTable() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_table, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        Lectures = new ArrayList<>();
        mAdapter = new TableAdapter(getActivity(), Lectures);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 4);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        fetchTableItems();
        return view;
    }
    private void fetchTableItems() {
        Tableclass test=new Tableclass("Advanced"+"\n"+" molocular"+"\n"+" cell","For All","Dr : Heba","11:00 am","Thursday");
        List<Tableclass> items = new ArrayList<>();
        items.add(test);
        Lectures.clear();
        Lectures.addAll(items);
        // refreshing recycler view
        mAdapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    class TableAdapter extends RecyclerView.Adapter<TableAdapter.MyViewHolder> {
        private Context context;
        private List<Tableclass> Lectures;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView Name, Instructor,Time,Group,day;
            public MyViewHolder(View view) {
                super(view);
                Name = view.findViewById(R.id.name);
                Instructor = view.findViewById(R.id.lecturer);
                day=view.findViewById(R.id.day);
                Time=view.findViewById(R.id.time);
                Group=view.findViewById(R.id.group);
            }
        }


        public TableAdapter(Context context, List<Tableclass> lectures) {
            this.context = context;
            this.Lectures = lectures;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.table_card, parent, false);

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            final Tableclass table = Lectures.get(position);
            holder.Name.setText(table.getName());
            holder.Instructor.setText(table.getLecturer());
            holder.Group.setText(table.getGroupe());
            holder.Time.setText(table.getTime());
            holder.day.setText(table.getDay());
        }

        @Override
        public int getItemCount() {
            return Lectures.size();
        }
    }
}
