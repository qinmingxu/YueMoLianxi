package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Loginbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public interface LoginService {
    void getData(Map<String,String> map, OnNetListener<Loginbean> onNetListener);
}
