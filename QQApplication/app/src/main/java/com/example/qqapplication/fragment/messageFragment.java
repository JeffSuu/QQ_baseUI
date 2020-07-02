package com.example.qqapplication.fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qqapplication.DrawActivity;
import com.example.qqapplication.R;
import com.example.qqapplication.adapter.msgAdapter;

public class messageFragment extends Fragment {
    private EditText mEt_msg;
    private RecyclerView recyclerView;
    private ImageView mIv_msg;
    private ImageView mIv_add;
    private PopupWindow popupWindow = null;
    private ImageView mIv_photo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mEt_msg = view.findViewById(R.id.et_message);
        recyclerView = view.findViewById(R.id.rv_msg);
        mIv_msg = view.findViewById(R.id.iv_msg);
        mIv_add = view.findViewById(R.id.iv_addd);
        mIv_photo = view.findViewById(R.id.iv_photo);

//        View view1 = getLayoutInflater().inflate(R.layout.layout_pop, null);
//        popupWindow = new PopupWindow(view1, 430, ViewGroup.LayoutParams.WRAP_CONTENT);
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow_background));
//        popupWindow.setOutsideTouchable(true);
//        popupWindow.setAnimationStyle(R.style.MyPopupWindow_anim_style);

//                    popupWindow.setFocusable(true);
//        popupWindow.setAnimationStyle(R.anim.scale_pop);
//        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//
//            }
//        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new msgAdapter(getContext()));
        mIv_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DrawActivity.class);

                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            }
        });
        mIv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                    popupWindow = new PopupWindow(view, 430, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setOutsideTouchable(true);

//                    popupWindow.setFocusable(true);
                    popupWindow.setAnimationStyle(R.style.MyPopupWindow_anim_style);
//                    popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow_background));
                    popupWindow.showAsDropDown(mIv_add, -350, 50);
                }
        });
        mIv_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }

//                else{
//                    View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
//                    popupWindow = new PopupWindow(view, 430, ViewGroup.LayoutParams.WRAP_CONTENT);
//                    popupWindow.setOutsideTouchable(true);
//
////                    popupWindow.setFocusable(true);
//                    popupWindow.setAnimationStyle(R.anim.scale_pop);
//                    popupWindow.showAsDropDown(mIv_add, -350, 50);
//
//
//                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
        Drawable leftDrawable = mEt_msg.getCompoundDrawables()[0];
        if (leftDrawable != null) {
            leftDrawable.setBounds(0, 0, 40, 40);
            mEt_msg.setCompoundDrawables(leftDrawable, mEt_msg.getCompoundDrawables()[1], mEt_msg.getCompoundDrawables()[2], mEt_msg.getCompoundDrawables()[3]);
        }
    }
}
