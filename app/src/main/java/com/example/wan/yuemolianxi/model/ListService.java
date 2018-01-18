package com.example.wan.yuemolianxi.model;

import com.example.wan.yuemolianxi.bean.Listbean;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public interface ListService {
    void getData(Map<String,String> map, OnNetListener<Listbean> onNetListener);

}
