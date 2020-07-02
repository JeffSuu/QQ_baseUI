package com.example.qqapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class DrawActivity extends AppCompatActivity {
    private ImageView mBt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_draw);
        mBt_back=findViewById(R.id.iv_back);
        mBt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.alpha_in,R.anim.alpha_in);
                finish();
               overridePendingTransition(R.anim.alpha_drawer_in,R.anim.alpha_drawer_out);

            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {



        if(keyCode==KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(R.anim.alpha_drawer_in,R.anim.alpha_drawer_out);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
