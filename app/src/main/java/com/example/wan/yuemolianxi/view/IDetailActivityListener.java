package com.example.wan.yuemolianxi.view;

import com.example.wan.yuemolianxi.bean.AddCartbean;
import com.example.wan.yuemolianxi.bean.Detailbean;

/**
 * Created by wan on 2018/1/17.
 */

public interface IDetailActivityListener {
    void show(Detailbean detailbean);
    void show(AddCartbean addCartbean);
}
