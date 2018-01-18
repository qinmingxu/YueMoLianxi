package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Loginbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class LoginModel implements LoginService{
    @Override
    public void getData(Map<String, String> map, final OnNetListener<Loginbean> onNetListener) {
        RetrofitManager.post("user/login", map, new BaseObserver<Loginbean>() {
            @Override
            public void success(Loginbean loginbean) {
                onNetListener.onSuccess(loginbean);
            }

            @Override
            public void failure(int code) {

            }


        });
    }
}
