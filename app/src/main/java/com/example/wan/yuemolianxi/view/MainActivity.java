package com.example.wan.yuemolianxi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.bean.EventBusMessage;
import com.example.wan.yuemolianxi.bean.Loginbean;
import com.example.wan.yuemolianxi.presenter.LoginPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IMainActivityListener {
    /**
     * 手机号/会员号/邮箱
     */
    private EditText mMobile;
    /**
     * 请输入密码
     */
    private EditText mPassword;
    /**
     * 新用户注册
     */
    private TextView mZhuce;
    /**
     * 登录
     */
    private Button mLogin;
    private long exittime = 0;
    private LoginPresenter loginPresenter;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginPresenter = new LoginPresenter(this);
        initView();

    }

    private void initView() {
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mZhuce = (TextView) findViewById(R.id.zhuce);
        mZhuce.setOnClickListener(this);
        mLogin = (Button) findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.zhuce:
                Intent intent = new Intent(MainActivity.this, RegActivity.class);
                startActivity(intent);
                break;
            case R.id.login:
                Map<String,String> map = new HashMap<>();
                map.put("mobile",mMobile.getText().toString());
                map.put("password",mPassword.getText().toString());
                loginPresenter.getData(map);

                break;
        }
    }
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - exittime < 2000){
            super.onBackPressed();
        }else {
            Toast.makeText(MainActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            exittime = System.currentTimeMillis();
        }
    }

    @Override
    public void show(Loginbean loginbean) {
        uid = loginbean.getData().getUid()+"";
       //Toast.makeText(MainActivity.this,uid,Toast.LENGTH_SHORT).show();
        EventBus.getDefault().postSticky(new EventBusMessage(uid));
        String code = loginbean.getCode();
        if(code.equals("0")){
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.deach();

    }

}
