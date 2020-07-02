package com.example.qqapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qqapplication.R;
import com.example.qqapplication.fragment.homeFragment;


public class home_friendAdapter extends RecyclerView.Adapter {
   public String[]  world= new String[]{"A","B","C","D","E","F","G","H","I"};
   private Context mcontext;
   private OnItemClickListener onItemClickListener;
   int a=0;
   public home_friendAdapter(Context context, OnItemClickListener listener){
       mcontext=context;
       onItemClickListener=listener;
   }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==0){
            return new viewholder2(LayoutInflater.from(mcontext).inflate(R.layout.home_friend_line,parent,false));
        }else {
            return new viewholder1(LayoutInflater.from(mcontext).inflate(R.layout.home_friend,parent,false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0) {
            return 0;
        }else if(position%8==0){
            return 0;

        }else return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
       if(getItemViewType(position)==0){
           ((viewholder2)holder).textView.setText(world[a]);

       }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }
    class viewholder1 extends RecyclerView.ViewHolder{
       private TextView textView;

        public viewholder1(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_usrname);
        }

    }
    class viewholder2 extends RecyclerView.ViewHolder{
        private TextView textView;

        public viewholder2(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.tv_word);
        }

    }
    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
