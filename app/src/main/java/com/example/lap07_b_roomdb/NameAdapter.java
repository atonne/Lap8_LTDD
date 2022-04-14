package com.example.lap07_b_roomdb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<String> nameArrayList;

    public NameAdapter(Context context, ArrayList<String> nameArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.nameArrayList = nameArrayList;

    }

    @NonNull
    @Override
    public NameAdapter.NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = layoutInflater.inflate(R.layout.item_name, parent, false);

        return new NameViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        String mCurrent = nameArrayList.get(position);
        holder.tvName.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        if(nameArrayList!=null && !nameArrayList.isEmpty())
            return nameArrayList.size();
        return 0;
    }

    public static class NameViewHolder extends RecyclerView.ViewHolder{
        //Button btnRemove = view.findViewById(R.id.btnRemove);
        TextView tvName;
        private static NameAdapter nameAdapter;

        public NameViewHolder(@NonNull View itemView, NameAdapter nameAdapter) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            this.nameAdapter = nameAdapter;
        }

//        public NameViewHolder(View view) {
//            super(view);
//        }

        public void bind(String text){
            tvName.setText(text);
        }

        static NameViewHolder create(ViewGroup parent){
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_name, parent, false);
            return new NameViewHolder(view, nameAdapter);
        }
    }
}

//public class NameAdapter extends BaseAdapter {
//    private Context context;
//    private int layout;
//    private ArrayList<Name> nameArrayList;
//    private AppDatabase db;
//    private int positionSelect = -1;
//
//    public NameAdapter(Context context, int layout, ArrayList<Name> nameArrayList, AppDatabase db) {
//        this.context = context;
//        this.layout = layout;
//        this.nameArrayList = nameArrayList;
//        this.db = db;
//    }
//
//    @Override
//    public int getCount() {
//        if(nameArrayList!=null && !nameArrayList.isEmpty())
//            return nameArrayList.size();
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    @Override
//    public View getView(final int i, View view, ViewGroup viewGroup) {
//        view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
//
//        //ListView listView = view.findViewById(R.id.lvName);
//        //Button btnRemove = view.findViewById(R.id.btnRemove);
//        TextView tvName = view.findViewById(R.id.tvName);
//        final ConstraintLayout layoutName = view.findViewById(R.id.layoutName);
//        final Name name = nameArrayList.get(i);
//
//        if(nameArrayList!=null && !nameArrayList.isEmpty()){
//            int id = name.getId();
//            tvName.setText(name.getName());
//        }
//
//        if(positionSelect==i)
//            layoutName.setBackgroundColor(Color.parseColor("#B3008C5A"));
//        else
//            layoutName.setBackgroundColor(Color.parseColor("#B36FBDA1"));
//
//        //pass data idName
////        view.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent=new Intent(new Intent(view.getContext(), MainActivity_Place.class));
////                intent.putExtra("id", name.getId());
////                view.getContext().startActivity(intent);
////
////                String log = "nameId: "+name.getId()+ " name: "+name.getName();
////                Log.d("nameadapter", log);
////
////                notifyDataSetChanged();
////            }
////        });
//
//        return view;
//    }
//
//}
