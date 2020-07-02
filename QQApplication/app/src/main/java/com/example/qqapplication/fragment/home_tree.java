package com.example.qqapplication.fragment;



import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.qqapplication.R;
import com.example.qqapplication.adapter.home_treeAdapter;


public class home_tree extends Fragment {
    private ExpandableListView expandableListView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.tree_recycleview,container,false);
        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        expandableListView=view.findViewById(R.id.ev_tree);

        expandableListView.setAdapter(new home_treeAdapter(getContext()));




    }
}
