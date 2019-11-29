package com.sanyue.mvcdemo.controller;

import android.content.Context;

import com.sanyue.mvcdemo.bean.UserBean;
import com.sanyue.mvcdemo.listenter.MainListenter;

public class MainController {
    private MainListenter listener;


    public  void httpGet(){
        //模拟网络请求
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserBean userBean = new UserBean();
        userBean.setAge("18");
        userBean.setName("张三");
        listener.success(userBean);
    }

    public static MainController getInstance(
                                             MainListenter listener) {
        Nested.Instance.listener = listener;
        return Nested.Instance;
    }

    private static class Nested {
        static final MainController Instance = new MainController();

    }
}
