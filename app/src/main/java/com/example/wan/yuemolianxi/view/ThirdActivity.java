package com.example.wan.yuemolianxi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.adapter.Myadapter;
import com.example.wan.yuemolianxi.bean.EventBusMessage;
import com.example.wan.yuemolianxi.bean.GetCartsbean;
import com.example.wan.yuemolianxi.bean.PriceAndCount;
import com.example.wan.yuemolianxi.presenter.GetCartsPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdActivity extends AppCompatActivity implements IThirdListener{
    private ExpandableListView mExlistview;
    /**
     * 全选
     */
    private CheckBox mBox;
    /**
     * 合计:
     */
    private TextView mTotal;
    /**
     * 去结算(0)
     */
    private TextView mCount;
    private GetCartsPresenter getCartsPresenter;
    private Myadapter myadapter;
    private int count;
    private double price;
    private String uid;
    List<GetCartsbean.DataBean> grouplist = new ArrayList<>();
    List<List<GetCartsbean.DataBean.ListBean>> childlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        EventBus.getDefault().register(this);
        getCartsPresenter = new GetCartsPresenter(this);
        Map<String,String> map = new HashMap<>();
        map.put("uid",uid);
        getCartsPresenter.getCarts(map);
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getCartsPresenter.deaach();
        EventBus.getDefault().unregister(this);
    }

    private void initView() {
        mExlistview = (ExpandableListView) findViewById(R.id.exlistview);
        mBox = (CheckBox) findViewById(R.id.box);
        mTotal = (TextView) findViewById(R.id.total);
        mCount = (TextView) findViewById(R.id.count);
        mExlistview.setGroupIndicator(null);
        mBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myadapter.AllOrNone(mBox.isChecked());
            }
        });
        mCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<=0){
                    Toast.makeText(ThirdActivity.this,"请先选择商品",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(ThirdActivity.this, OrderActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public void show(List<GetCartsbean.DataBean> group, List<List<GetCartsbean.DataBean.ListBean>> child) {
        grouplist.addAll(group);
        childlist.addAll(child);
        myadapter = new Myadapter(this, group, child);
        mExlistview.setAdapter(myadapter);
        for (int i = 0; i < group.size(); i++) {
            mExlistview.expandGroup(i);
        }
    }
    public void setPriceAndCount(PriceAndCount priceAndCount){
        count = priceAndCount.getCount();
        price = priceAndCount.getPrice();
        mTotal.setText("合计:"+price);
        mCount.setText("去结算("+ count +")");
    }
    public void setAllChecked(boolean b){
        mBox.setChecked(b);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void get(EventBusMessage eventBusMessage){
        uid = eventBusMessage.getMessage();
    }


}
