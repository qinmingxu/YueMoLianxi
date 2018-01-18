package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.Detailbean;
import com.example.wan.yuemolianxi.model.DetailModel;
import com.example.wan.yuemolianxi.model.DetailService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IDetailActivityListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class DetailPresenter {
    private IDetailActivityListener iDetailActivityListener;
    private final DetailService detailService;

    public DetailPresenter(IDetailActivityListener iDetailActivityListener) {
        this.iDetailActivityListener = iDetailActivityListener;
        detailService = new DetailModel();
    }
    public void getData(Map<String,String> map){
        detailService.getData(map, new OnNetListener<Detailbean>() {
            @Override
            public void onSuccess(Detailbean detailbean) {
                if(iDetailActivityListener!=null){
                    iDetailActivityListener.show(detailbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void deach(){
        iDetailActivityListener=null;
    }
}
