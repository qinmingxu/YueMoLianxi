package com.example.wan.yuemolianxi.model;


import com.example.wan.yuemolianxi.bean.AddCartbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public interface AddCartService {
    void AddCart(Map<String, String> parms, OnNetListener<AddCartbean> onNetListener);
}
