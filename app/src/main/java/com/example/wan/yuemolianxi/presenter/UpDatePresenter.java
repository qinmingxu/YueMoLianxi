package com.example.wan.yuemolianxi.presenter;

import android.util.Log;

import com.example.wan.yuemolianxi.bean.UpDatebean;
import com.example.wan.yuemolianxi.model.UpDateModel;
import com.example.wan.yuemolianxi.model.UpDateService;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/18.
 */

public class UpDatePresenter {
    public static UpDateService upDateService = new UpDateModel();

    public static void getData(Map<String,String> map) {
        upDateService.getData(map, new OnNetListener<UpDatebean>() {
            @Override
            public void onSuccess(UpDatebean upDatebean) {

                Log.e("秦明旭",upDatebean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

}
