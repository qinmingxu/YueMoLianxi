package com.example.wan.yuemolianxi.view;


import com.example.wan.yuemolianxi.bean.GetCartsbean;

import java.util.List;

/**
 * Created by wan on 2017/12/20.
 */

public interface IThirdListener {
    void show(List<GetCartsbean.DataBean> group, List<List<GetCartsbean.DataBean.ListBean>> child);
}
