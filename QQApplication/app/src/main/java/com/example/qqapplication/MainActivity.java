package com.example.qqapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
    private ImageView iv_login;
    private EditText mEt1;
    private EditText mET2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main);
        iv_login=findViewById(R.id.iv_go);



        iv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), StartActivity.class);
                startActivity(intent);

            }
        });
    }

}
