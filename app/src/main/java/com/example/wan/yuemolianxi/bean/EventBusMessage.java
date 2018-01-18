package com.example.wan.yuemolianxi.bean;


public class EventBusMessage {


    //定义了发送的消息必须是String.


    public String message;


    public EventBusMessage(String message) {


        this.message = message;


    }

    public String getMessage() {
        return message;
    }

    public EventBusMessage setMessage(String message) {
        this.message = message;
        return this;
    }
}
