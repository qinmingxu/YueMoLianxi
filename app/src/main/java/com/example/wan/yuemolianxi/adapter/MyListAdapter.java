package com.example.wan.yuemolianxi.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.bean.Listbean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by wan on 2018/1/17.
 */
public class MyListAdapter extends BaseAdapter{
    Context context;
    List<Listbean.DataBean> list;
    public MyListAdapter(Context context, List<Listbean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder;
        if(convertView==null){
            view = View.inflate(context,R.layout.item,null);
            holder= new ViewHolder();
            holder.image=view.findViewById(R.id.my_image_view);
            holder.title=view.findViewById(R.id.title);
            holder.miaoshu=view.findViewById(R.id.miaoshu);
            view.setTag(holder);
        }else {
            view=convertView;
            holder= (ViewHolder) view.getTag();
        }
        holder.title.setText(list.get(position).getTitle());
        holder.miaoshu.setText(list.get(position).getSubhead());
        String[] split = list.get(position).getImages().split("\\|");
        holder.image.setImageURI(Uri.parse(split[0]));
        return view;
    }
    class ViewHolder{
        SimpleDraweeView image;
        TextView title;
        TextView miaoshu;
    }
}
