package com.example.wan.yuemolianxi.view;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.adapter.MyOrderadapter;
import com.example.wan.yuemolianxi.bean.Orderbean;
import com.example.wan.yuemolianxi.presenter.OrderPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderActivity extends AppCompatActivity implements View.OnClickListener ,IOederActivityListener{

    private ImageView mImage;
    /**
     * 全部
     */
    private Button mButton1;
    /**
     * 待支付
     */
    private Button mButton2;
    /**
     * 已支付
     */
    private Button mButton3;
    /**
     * 已取消
     */
    private Button mButton4;
    private XRecyclerView mRecycle;
    private LinearLayout mActivityOrder;
    private OrderPresenter orderPresenter;
    private View parent;
    private View contentView;
    private PopupWindow popupWindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initView();
        orderPresenter = new OrderPresenter(this);
        Map<String,String> map = new HashMap<>();
        map.put("uid",71+"");
        orderPresenter.getData(map);
    }

    private void initView() {
        mImage = (ImageView) findViewById(R.id.image);
        mImage.setOnClickListener(this);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton3.setOnClickListener(this);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton4.setOnClickListener(this);
        mRecycle = (XRecyclerView) findViewById(R.id.recycle);
        mActivityOrder = (LinearLayout) findViewById(R.id.activity_order);
        mRecycle.setPullRefreshEnabled(false);
        mRecycle.setLoadingMoreEnabled(false);
        contentView = View.inflate(OrderActivity.this, R.layout.pop, null);
        //父窗体
        parent = View.inflate(OrderActivity.this, R.layout.activity_order, null);
        popupWindow = new PopupWindow(contentView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        /**
         * 出现的问题,,,点击周围不消失,,点击返回键直接退出这个activity...里面的editText控件不能输入
         */
        popupWindow.setTouchable(true);//设置窗体可以触摸,,,默认就是true
        popupWindow.setFocusable(true);//让窗体获取到焦点...一般情况下窗体里面的控件都能获取到焦点,但是editText特殊
        popupWindow.setOutsideTouchable(true);//设置窗体外部可以触摸
        popupWindow.setBackgroundDrawable(new BitmapDrawable());//设置背景
        final TextView text1 = contentView.findViewById(R.id.text1);
        final TextView text2 = contentView.findViewById(R.id.text2);
        final TextView text3 = contentView.findViewById(R.id.text3);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map1 = new HashMap<>();
                map1.put("uid",71+"");
                map1.put("status","0");
                orderPresenter.getData(map1);
                text1.setBackgroundColor(Color.GREEN);
                text2.setBackgroundColor(Color.WHITE);
                text3.setBackgroundColor(Color.WHITE);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map1 = new HashMap<>();
                map1.put("uid",71+"");
                map1.put("status","1");
                orderPresenter.getData(map1);
                text2.setBackgroundColor(Color.GREEN);
                text3.setBackgroundColor(Color.WHITE);
                text1.setBackgroundColor(Color.WHITE);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Map<String,String> map1 = new HashMap<>();
                map1.put("uid",71+"");
                map1.put("status","2");
                orderPresenter.getData(map1);
                text3.setBackgroundColor(Color.GREEN);
                text2.setBackgroundColor(Color.WHITE);
                text1.setBackgroundColor(Color.WHITE);

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.image:
                popupWindow.showAsDropDown(mImage, -50, 25);
                break;
            case R.id.button1:
                Map<String,String> map = new HashMap<>();
                map.put("uid",71+"");
                orderPresenter.getData(map);
                break;
            case R.id.button2:
                Map<String,String> map1 = new HashMap<>();
                map1.put("uid",71+"");
                map1.put("status","0");
                orderPresenter.getData(map1);
                break;
            case R.id.button3:
                Map<String,String> map2 = new HashMap<>();
                map2.put("uid",71+"");
                map2.put("status","1");
                orderPresenter.getData(map2);
                break;
            case R.id.button4:
                Map<String,String> map3 = new HashMap<>();
                map3.put("uid",71+"");
                map3.put("status","2");
                orderPresenter.getData(map3);
                break;
        }
    }

    @Override
    public void show(Orderbean orderbean) {
        List<Orderbean.DataBean> list = orderbean.getData();
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycle.setLayoutManager(layoutManager);
        MyOrderadapter myOrderadapter = new MyOrderadapter(OrderActivity.this, list);
        mRecycle.setAdapter(myOrderadapter);
    }
}
