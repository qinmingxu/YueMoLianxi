package com.example.wan.yuemolianxi.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.adapter.MyListAdapter;
import com.example.wan.yuemolianxi.bean.Listbean;
import com.example.wan.yuemolianxi.presenter.ListPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity implements IListActivityListener {

    private ListView mListview;
    List<Listbean.DataBean> list = new ArrayList<>();
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initView();
        ListPresenter listPresenter = new ListPresenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("pscid", "39");
        map.put("page", "1");
        listPresenter.getData(map);

    }

    private void initView() {
        mListview = (ListView) findViewById(R.id.listview);
        mText = (TextView) findViewById(R.id.text);
    }

    @Override
    public void show(final Listbean listbean) {
        list.addAll(listbean.getData());
        MyListAdapter myListAdapter = new MyListAdapter(ListActivity.this, list);
        mListview.setAdapter(myListAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("pid",listbean.getData().get(position).getPid()+"");

                startActivity(intent);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }



}
