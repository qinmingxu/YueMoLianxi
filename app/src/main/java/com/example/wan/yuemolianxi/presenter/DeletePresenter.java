package com.example.wan.yuemolianxi.presenter;

import android.util.Log;

import com.example.wan.yuemolianxi.bean.Deletebean;
import com.example.wan.yuemolianxi.model.DeleteModel;
import com.example.wan.yuemolianxi.model.DeleteService;
import com.example.wan.yuemolianxi.net.OnNetListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class DeletePresenter {
    public static DeleteService deleteService = new DeleteModel();

    public static void getData(Map<String,String> map) {
        deleteService.getData(map, new OnNetListener<Deletebean>() {
            @Override
            public void onSuccess(Deletebean deletebean) {
                Log.e("秦明旭",deletebean.getMsg());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
