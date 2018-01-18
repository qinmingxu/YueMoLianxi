package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.AddCartbean;
import com.example.wan.yuemolianxi.model.AddCartModel;
import com.example.wan.yuemolianxi.model.AddCartService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IDetailActivityListener;

import java.util.Map;

/**
 * Created by wan on 2017/12/18.
 */

public class AddCartPresenter {
    private IDetailActivityListener iDetailActivityListener;
    private final AddCartService addCartService;

    public AddCartPresenter(IDetailActivityListener iDetailActivityListener) {
        this.iDetailActivityListener = iDetailActivityListener;
        addCartService = new AddCartModel();
    }
    public void deaach(){
        iDetailActivityListener=null;
    }
    public void getData(Map<String,String> map){
        addCartService.AddCart(map, new OnNetListener<AddCartbean>() {
            @Override
            public void onSuccess(AddCartbean addCartbean) {
                if(iDetailActivityListener!=null){
                    iDetailActivityListener.show(addCartbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
