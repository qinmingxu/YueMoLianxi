package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.AddCartbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public class AddCartModel implements AddCartService {

    @Override
    public void AddCart(Map<String, String> parms, final OnNetListener<AddCartbean> onNetListener) {
        RetrofitManager.post("product/addCart", parms, new BaseObserver<AddCartbean>() {
            @Override
            public void success(AddCartbean addCartbean) {
                onNetListener.onSuccess(addCartbean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
