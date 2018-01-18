package com.example.wan.yuemolianxi.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wan.yuemolianxi.R;
import com.example.wan.yuemolianxi.bean.Orderbean;
import com.example.wan.yuemolianxi.presenter.UpDatePresenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wan on 2018/1/18.
 */
public class MyOrderadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Orderbean.DataBean> list;
    public MyOrderadapter(Context context, List<Orderbean.DataBean> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder holder1 = (ViewHolder) holder;
        holder1.title.setText(list.get(position).getTitle());
        holder1.price.setText(list.get(position).getPrice()+"");
        holder1.time.setText(list.get(position).getCreatetime());
        int status = list.get(position).getStatus();
        if(status==0){
            holder1.status.setTextColor(Color.RED);
            holder1.status.setText("待支付");
            holder1.dstatus.setText("取消订单");
            holder1.dstatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("取消订单");
                    builder.setMessage("确定要取消订单吗?");
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            int orderid = list.get(position).getOrderid();
                            UpDatePresenter upDatePresenter = new UpDatePresenter();
                            Map<String,String> map = new HashMap<String, String>();
                            map.put("uid","71");
                            map.put("status","2");
                            map.put("orderid",orderid+"");
                            upDatePresenter.getData(map);
                            notifyDataSetChanged();
                            Toast.makeText(context,"订单状态修改成功",Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });
        }else if(status==1){
            holder1.status.setText("已支付");
            holder1.dstatus.setText("查看订单");
        }else {
            holder1.status.setText("已取消");
            holder1.dstatus.setText("查看订单");
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView price;
        private final TextView time;
        private final TextView status;
        private final TextView dstatus;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            time = itemView.findViewById(R.id.time);
            status = itemView.findViewById(R.id.status);
            dstatus = itemView.findViewById(R.id.dstatus);
        }
    }
}
