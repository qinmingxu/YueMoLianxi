package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Regbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/16.
 */

public interface RegService {
    void getData(Map<String,String> map, OnNetListener<Regbean> onNetListener);
}
