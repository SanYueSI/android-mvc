package com.sanyue.mvcdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sanyue.mvcdemo.bean.UserBean;
import com.sanyue.mvcdemo.controller.MainController;
import com.sanyue.mvcdemo.listenter.MainListenter;


public class MainActivity extends AppCompatActivity implements MainListenter {
    private TextView tv_context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_context= findViewById(R.id.tv_context);
        tv_context.setOnClickListener(v->{
            MainController.getInstance(this).httpGet();
        });
    }

    @Override
    public void success(UserBean bean) {
        tv_context.setText(bean.getName()+bean.getAge()+"岁了");

    }
}
