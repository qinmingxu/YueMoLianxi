package com.example.wan.yuemolianxi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.application.GlideImageLoader;
import com.example.wan.yuemolianxi.bean.AddCartbean;
import com.example.wan.yuemolianxi.bean.Detailbean;
import com.example.wan.yuemolianxi.bean.EventBusMessage;
import com.example.wan.yuemolianxi.presenter.AddCartPresenter;
import com.example.wan.yuemolianxi.presenter.DetailPresenter;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity implements IDetailActivityListener {


    @BindView(R.id.back)
    ImageView mBack;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    @BindView(R.id.fenxiang)
    ImageView mFenxiang;
    @BindView(R.id.linear)
    LinearLayout mLinear;
    @BindView(R.id.view)
    View mView;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.cart)
    ImageView mCart;
    @BindView(R.id.addcart)
    ImageView mAddcart;
    @BindView(R.id.linear02)
    LinearLayout mLinear02;
    @BindView(R.id.activity_detail)
    RelativeLayout mActivityDetail;
    @BindView(R.id.miao)
    TextView mMiao;
    @BindView(R.id.price)
    TextView mPrice;
    @BindView(R.id.price02)
    TextView mPrice02;
    private AddCartPresenter addCartPresenter;
    private String pid;
    private DetailPresenter detailPresenter;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");
        detailPresenter = new DetailPresenter(this);
        addCartPresenter = new AddCartPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("pid", pid);
        detailPresenter.getData(map);
        mTabLayout.addTab(mTabLayout.newTab().setText("商品"));
        mTabLayout.addTab(mTabLayout.newTab().setText("详情"));
        mTabLayout.addTab(mTabLayout.newTab().setText("评价"));
    }


    @Override
    public void show(Detailbean detailbean) {
        String images2 = detailbean.getData().getImages();
        String[] split = images2.split("\\|");
        List<String> images = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            images.add(split[i]);
        }
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mMiao.setText(detailbean.getData().getTitle());
        mPrice.setText(detailbean.getData().getSubhead());
        mPrice02.setText("¥:"+detailbean.getData().getPrice()+"");
    }

    @Override
    public void show(AddCartbean addCartbean) {
        Toast.makeText(DetailActivity.this,addCartbean.getMsg().toString(),Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.back, R.id.cart, R.id.addcart})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.back:
                break;
            case R.id.cart:
                Intent intent = new Intent(DetailActivity.this, ThirdActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.addcart:
                Map<String,String> map = new HashMap<>();
                map.put("pid",pid);
                map.put("uid",uid);
                addCartPresenter.getData(map);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailPresenter.deach();
        addCartPresenter.deaach();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void get(EventBusMessage eventBusMessage){
        uid = eventBusMessage.getMessage();
    }
}
