package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Listbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class ListModel implements ListService {

    @Override
    public void getData(Map<String, String> map, final OnNetListener<Listbean> onNetListener) {
        RetrofitManager.post("product/getProducts", map, new BaseObserver<Listbean>() {
            @Override
            public void success(Listbean listbean) {
                onNetListener.onSuccess(listbean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
