package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Orderbean;
import com.example.wan.yuemolianxi.net.BaseObserver;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.net.RetrofitManager;

import java.util.Map;

/**
 * Created by wan on 2018/1/18.
 */

public class OrderModel implements OrderService{

    @Override
    public void getData(Map<String, String> map, final OnNetListener<Orderbean> onNetListener) {
        RetrofitManager.post("product/getOrders", map, new BaseObserver<Orderbean>() {
            @Override
            public void success(Orderbean orderbean) {
                onNetListener.onSuccess(orderbean);
            }

            @Override
            public void failure(int code) {

            }

        });
    }
}
