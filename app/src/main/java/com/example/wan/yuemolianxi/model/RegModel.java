package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Regbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class RegModel implements RegService {
    @Override
    public void getData(Map<String, String> map, final OnNetListener<Regbean> onNetListener) {

        RetrofitManager.post("user/reg", map, new BaseObserver<Regbean>() {


            @Override
            public void success(Regbean regbean) {
                onNetListener.onSuccess(regbean);
            }

            @Override
            public void failure(int code) {

            }
        });
    }
}
