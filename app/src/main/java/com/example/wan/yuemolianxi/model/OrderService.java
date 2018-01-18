package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Orderbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/18.
 */

public interface OrderService {
    void getData(Map<String,String> map, OnNetListener<Orderbean> onNetListener);
}
