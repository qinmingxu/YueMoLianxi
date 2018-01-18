package com.example.wan.yuemolianxi.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.bean.Regbean;
import com.example.wan.yuemolianxi.presenter.RegPresenter;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegActivity extends AppCompatActivity implements View.OnClickListener,IRegActivityListener {

    private ImageView mBack;
    /**
     * 请输入手机号
     */
    private EditText mMobile;
    /**
     * 请输入密码
     */
    private EditText mPassword;
    /**
     * 确认输入密码
     */
    private EditText mPasswordagain;
    /**
     * 请填写邮箱
     */
    private EditText mYouxiang;
    /**
     * 注册
     */
    private Button mReg;
    private LinearLayout mActivityReg;

    boolean flag = true;
    private RegPresenter regPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        regPresenter = new RegPresenter(this);
        initView();

    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);
        mMobile = (EditText) findViewById(R.id.mobile);
        mPassword = (EditText) findViewById(R.id.password);
        mPasswordagain = (EditText) findViewById(R.id.passwordagain);
        mYouxiang = (EditText) findViewById(R.id.youxiang);
        mReg = (Button) findViewById(R.id.reg);
        mReg.setOnClickListener(this);
        mBack.setOnClickListener(this);
        mActivityReg = (LinearLayout) findViewById(R.id.activity_reg);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.reg:
                if (TextUtils.isEmpty(mMobile.getText().toString()) || TextUtils.isEmpty(mPassword.getText().toString()) || TextUtils.isEmpty(mPasswordagain.getText().toString()) || TextUtils.isEmpty(mYouxiang.getText().toString())) {
                   // Toast.makeText(RegActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else if (!isChinaPhoneLegal(mMobile.getText().toString())) {
                   // Toast.makeText(RegActivity.this, "请输入正确手机号", Toast.LENGTH_SHORT).show();
                    flag = false;
                } else if (!mPassword.getText().toString().equals(mPasswordagain.getText().toString())) {
                    Toast.makeText(RegActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    flag = false;
                }
                if (flag = true) {
                    Map<String,String> map = new HashMap<>();
                    map.put("mobile",mMobile.getText().toString());
                    map.put("password",mPassword.getText().toString());
                    regPresenter.getData(map);
                }

                break;
            case R.id.back:
                finish();
                break;
        }
    }

    public static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    @Override
    public void show(Regbean regbean) {
        Toast.makeText(RegActivity.this,regbean.getMsg().toString(),Toast.LENGTH_SHORT).show();
        String code = regbean.getCode();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        regPresenter.deach();
    }
}
