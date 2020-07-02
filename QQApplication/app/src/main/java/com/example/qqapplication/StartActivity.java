package com.example.qqapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.qqapplication.fragment.homeFragment;
import com.example.qqapplication.fragment.messageFragment;
import com.example.qqapplication.fragment.spaceFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {
    private LinearLayout linearLayout_home,linearLayout_message,linearLayout_space;
    private Fragment fg_message,fg_home,fg_space;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);
        fg_home=new homeFragment(StartActivity.this);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_1,fg_home).commitAllowingStateLoss();
        Myonclick myonclick=new Myonclick();
        linearLayout_home=findViewById(R.id.ll_home);
        linearLayout_message=findViewById(R.id.ll_message);
        linearLayout_space=findViewById(R.id.ll_space);
        linearLayout_space.setOnClickListener(myonclick);
        linearLayout_home.setOnClickListener(myonclick);
        linearLayout_message.setOnClickListener(myonclick);

    }



    class Myonclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ll_home:
                if(fg_home==null){
                    fg_home=new homeFragment(StartActivity.this );
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_1,fg_home).commitAllowingStateLoss();
                    getWindow().setBackgroundDrawable(getDrawable(R.color.colorWhite));
                    //获取ActionBar对象

                    break;
                case R.id.ll_message:
                    if(fg_message==null){
                        fg_message=new messageFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_1,fg_message).commitAllowingStateLoss();
                    getWindow().setBackgroundDrawable(getDrawable(R.color.colorWhite));

                    break;
                case R.id.ll_space:
                    if(fg_space==null){
                        fg_space=new spaceFragment();
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fl_1,fg_space).commitAllowingStateLoss();
                    getWindow().setBackgroundDrawable(getDrawable(R.drawable.qqstart));

                    break;
                    default:
                        break;
            }
        }
    }

}
