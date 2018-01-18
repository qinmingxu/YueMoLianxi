package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.Regbean;
import com.example.wan.yuemolianxi.model.RegModel;
import com.example.wan.yuemolianxi.model.RegService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IRegActivityListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/16.
 */

public class RegPresenter {
    private IRegActivityListener iRegActivityListener;
    private final RegService regService;

    public RegPresenter(IRegActivityListener iRegActivityListener) {
        this.iRegActivityListener = iRegActivityListener;
        regService = new RegModel();
    }
    public void getData(Map<String,String> map){
        regService.getData(map, new OnNetListener<Regbean>() {
            @Override
            public void onSuccess(Regbean regbean) {
                if(iRegActivityListener!=null){
                    iRegActivityListener.show(regbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void deach(){
        iRegActivityListener=null;
    }
}
