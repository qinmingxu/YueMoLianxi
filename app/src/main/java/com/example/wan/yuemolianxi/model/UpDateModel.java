package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.UpDatebean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public class UpDateModel implements UpDateService {

    @Override
    public void getData(Map<String, String> parms, final OnNetListener<UpDatebean> onNetListener) {
        RetrofitManager.post("product/updateOrder", parms, new BaseObserver<UpDatebean>() {
            @Override
            public void success(UpDatebean upDatebean) {
                onNetListener.onSuccess(upDatebean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
