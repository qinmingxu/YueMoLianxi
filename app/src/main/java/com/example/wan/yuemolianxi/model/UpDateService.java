package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.UpDatebean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public interface UpDateService {
    void getData(Map<String, String> map, OnNetListener<UpDatebean> onNetListener);

}
