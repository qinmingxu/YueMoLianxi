package com.example.wan.yuemolianxi.bean;

import java.util.List;

/**
 * Created by wan on 2018/1/18.
 */

public class Orderbean {

    /**
     * msg : 请求成功
     * code : 0
     * data : [{"createtime":"2017-12-21T11:56:50","orderid":5070,"price":99.99,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T11:57:20","orderid":5074,"price":15255,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:06:58","orderid":5128,"price":100,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:07:00","orderid":5129,"price":100,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:11:13","orderid":5131,"price":99.99,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:24:26","orderid":5134,"price":5,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:28:44","orderid":5136,"price":45965,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:32:18","orderid":5137,"price":2999,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:32:30","orderid":5138,"price":123,"status":0,"title":"订单测试标题71","uid":71},{"createtime":"2017-12-21T14:57:54","orderid":5152,"price":9.9,"status":0,"title":"订单测试标题71","uid":71}]
     * page : 1
     */

    private String msg;
    private String code;
    private String page;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createtime : 2017-12-21T11:56:50
         * orderid : 5070
         * price : 99.99
         * status : 0
         * title : 订单测试标题71
         * uid : 71
         */

        private String createtime;
        private int orderid;
        private double price;
        private int status;
        private String title;
        private int uid;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getOrderid() {
            return orderid;
        }

        public void setOrderid(int orderid) {
            this.orderid = orderid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }
    }
}
