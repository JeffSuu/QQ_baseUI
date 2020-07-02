package com.example.qqapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qqapplication.R;
import com.example.qqapplication.adapter.home_friendAdapter;

public class home_friend extends Fragment {
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_friend_fragment,container,false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerView=view.findViewById(R.id.rv_friend);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new home_friendAdapter(getContext(), new home_friendAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {

            }
        }));

    }
}
