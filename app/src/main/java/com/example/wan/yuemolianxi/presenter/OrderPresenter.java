package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.Orderbean;
import com.example.wan.yuemolianxi.model.OrderModel;
import com.example.wan.yuemolianxi.model.OrderService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IOederActivityListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/18.
 */

public class OrderPresenter {
    private IOederActivityListener iOederActivityListener;
    private final OrderService orderService;

    public OrderPresenter(IOederActivityListener iOederActivityListener) {
        this.iOederActivityListener = iOederActivityListener;
        orderService = new OrderModel();
    }
    public void getData(Map<String,String> map){
        orderService.getData(map, new OnNetListener<Orderbean>() {
            @Override
            public void onSuccess(Orderbean orderbean) {
                if(iOederActivityListener!=null){
                    iOederActivityListener.show(orderbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
