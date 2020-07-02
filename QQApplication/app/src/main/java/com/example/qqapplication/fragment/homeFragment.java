package com.example.qqapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.qqapplication.DrawActivity;
import com.example.qqapplication.R;
import com.example.qqapplication.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

public class homeFragment extends Fragment {
    private EditText mEt_search;
    private TextView mTv_newfriend;
    private boolean frag=true;
    private ImageView imageView;
    private Context mcontext;
    private Button mBt_tree,mBt_friend;
    ViewPager mVp;
    home_tree tree;
    home_friend friend;
    List<Fragment> fragmentList = new ArrayList<Fragment>();


    public homeFragment(Context context){
        mcontext=context;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_user,container,false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEt_search=view.findViewById(R.id.et_search);
        mBt_friend=view.findViewById(R.id.bt_1);
        mBt_tree=view.findViewById(R.id.bt_2);
        mBt_tree.setBackgroundColor(Color.parseColor("#ffffff"));
        mBt_friend.setBackgroundColor(Color.parseColor("#cccccc"));


        mVp=view.findViewById(R.id.vp_home);
        mTv_newfriend=view.findViewById(R.id.tv_new);
        imageView=view.findViewById(R.id.iv_drawer);
        tree=new home_tree();
        friend=new home_friend();
        fragmentList.add(friend);
        fragmentList.add(tree);
        mVp.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),fragmentList));
        mVp.setCurrentItem(1);
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        mBt_friend.setBackgroundColor(Color.parseColor("#ffffff"));
                        mBt_tree.setBackgroundColor(Color.parseColor("#cccccc"));
                        break;
                    case 1:
                        mBt_tree.setBackgroundColor(Color.parseColor("#ffffff"));
                        mBt_friend.setBackgroundColor(Color.parseColor("#cccccc"));
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBt_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVp.setCurrentItem(0);
            }
        });
        mBt_tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVp.setCurrentItem(1);
            }
        });
//        getChildFragmentManager().beginTransaction().add(R.id.fl_user,new home_friend()).commitAllowingStateLoss();


//        mBt_tree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(frag){
//                    getChildFragmentManager().beginTransaction().replace(R.id.fl_user,new home_tree()).commitAllowingStateLoss();
//                    frag=false;
//                }
//            }
//        });
//        mBt_friend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(!frag){
//                    getChildFragmentManager().beginTransaction().replace(R.id.fl_user,new home_friend()).commitAllowingStateLoss();
//                    frag=true;
//                }
//            }
//        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getContext(), DrawActivity.class);

                startActivity(intent);
               getActivity().overridePendingTransition(R.anim.alpha_in,R.anim.alpha_out);

            }
        });






        Drawable leftDrawable = mEt_search.getCompoundDrawables()[0];
        if(leftDrawable!=null){
            leftDrawable.setBounds(0, 0, 40, 40);
            mEt_search.setCompoundDrawables(leftDrawable, mEt_search.getCompoundDrawables()[1], mEt_search.getCompoundDrawables()[2], mEt_search.getCompoundDrawables()[3]);
        }
        Drawable rightDrawable = mTv_newfriend.getCompoundDrawables()[2];
        if(rightDrawable!=null){
            rightDrawable.setBounds(0, 0, 35, 35);
            mTv_newfriend.setCompoundDrawables(mTv_newfriend.getCompoundDrawables()[0],null , mTv_newfriend.getCompoundDrawables()[2], mTv_newfriend.getCompoundDrawables()[3]);
        }


    }
}
