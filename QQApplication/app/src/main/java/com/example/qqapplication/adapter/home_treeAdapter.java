package com.example.qqapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.qqapplication.R;


public class home_treeAdapter extends BaseExpandableListAdapter {
    private Context mcontext;
    private String[] group =new String []{"好","好","学","习","，","天","天","向","上"};
    public home_treeAdapter(Context context){
        mcontext=context;
    }
    @Override
    public int getGroupCount() {
        return 9;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 12;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


        View view= LayoutInflater.from(mcontext).inflate(R.layout.tree_group,parent,false);
        TextView textView=view.findViewById(R.id.tv_group);
        textView.setText(group[groupPosition]);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view=LayoutInflater.from(mcontext).inflate(R.layout.tree_group_member,parent,false);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}