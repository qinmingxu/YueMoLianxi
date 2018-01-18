package com.example.wan.yuemolianxi.model;


import com.example.wan.yuemolianxi.bean.GetCartsbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public interface GetCartsService {
    void getCarts(Map<String, String> parms, OnNetListener<GetCartsbean> onNetListener);
}
