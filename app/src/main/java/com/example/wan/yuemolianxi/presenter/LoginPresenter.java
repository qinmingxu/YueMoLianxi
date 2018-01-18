package com.example.wan.yuemolianxi.presenter;

import com.example.wan.yuemolianxi.bean.Loginbean;
import com.example.wan.yuemolianxi.model.LoginModel;
import com.example.wan.yuemolianxi.model.LoginService;
import com.example.wan.yuemolianxi.net.OnNetListener;
import com.example.wan.yuemolianxi.view.IMainActivityListener;

import java.util.Map;

/**
 * Created by wan on 2018/1/17.
 */

public class LoginPresenter {
    private IMainActivityListener iMainActivityListener;
    private final LoginService loginService;

    public LoginPresenter(IMainActivityListener iMainActivityListener) {
        this.iMainActivityListener = iMainActivityListener;
        loginService = new LoginModel();
    }
    public void getData(Map<String,String> map){
        loginService.getData(map, new OnNetListener<Loginbean>() {
            @Override
            public void onSuccess(Loginbean loginbean) {
                if(iMainActivityListener!=null){
                    iMainActivityListener.show(loginbean);
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    public void deach(){
        iMainActivityListener=null;
    }
}
