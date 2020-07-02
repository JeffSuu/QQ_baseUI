package com.example.qqapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qqapplication.R;

public class msgAdapter extends RecyclerView.Adapter {
    private Context mcontext;

    public msgAdapter(Context context){
        mcontext=context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(mcontext).inflate(R.layout.msg_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 40;
    }
    class viewholder extends RecyclerView.ViewHolder{
        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
