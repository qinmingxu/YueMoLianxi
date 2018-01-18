package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Deletebean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class DeleteModel implements DeleteService {
    @Override
    public void getData(Map<String, String> map, final OnNetListener<Deletebean> onNetListener) {
        RetrofitManager.post("product/deleteCart", map, new BaseObserver<Deletebean>() {
            @Override
            public void success(Deletebean deletebean) {
                onNetListener.onSuccess(deletebean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
