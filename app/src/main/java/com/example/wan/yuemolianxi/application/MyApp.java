package com.example.wan.yuemolianxi.application;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by wan on 2018/1/17.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this,Fresco_ImagePipelineConfigUtil.getDefaultImagePipelineConfig(this));
    }
}
