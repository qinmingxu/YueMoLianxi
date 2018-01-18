package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Detailbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class DetailModel implements DetailService {
    @Override
    public void getData(Map<String, String> map, final OnNetListener<Detailbean> onNetListener) {
        RetrofitManager.post("product/getProductDetail", map, new BaseObserver<Detailbean>() {
            @Override
            public void success(Detailbean detailbean) {
                onNetListener.onSuccess(detailbean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
