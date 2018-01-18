package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.Listbean;
import com.example.wan.yuemolianxi.model.ListModel;
import com.example.wan.yuemolianxi.model.ListService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IListActivityListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class ListPresenter {
    private IListActivityListener iListActivityListener;
    private final ListService listService;

    public ListPresenter(IListActivityListener iListActivityListener) {
        this.iListActivityListener = iListActivityListener;
        listService = new ListModel();
    }
    public void getData(Map<String,String> map){
        listService.getData(map, new OnNetListener<Listbean>() {
            @Override
            public void onSuccess(Listbean listbean) {
                if(iListActivityListener!=null){
                    iListActivityListener.show(listbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void deach(){
        iListActivityListener=null;
    }
}
