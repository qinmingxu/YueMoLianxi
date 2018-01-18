package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.GetCartsbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public class GetCartsModel implements GetCartsService {

    @Override
    public void getCarts(Map<String, String> parms, final OnNetListener<GetCartsbean> onNetListener) {
        RetrofitManager.post("product/getCarts", parms, new BaseObserver<GetCartsbean>() {
            @Override
            public void success(GetCartsbean getCartsbean) {
                onNetListener.onSuccess(getCartsbean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
