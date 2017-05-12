package com.example.eventbus_text;

/**
 * date: 2017/5/12
 * author: 史洲铭(lenovo)
 * function:
 */

public class FirstEvent {
    private String mMsg;
    public FirstEvent(String msg) {
        // TODO Auto-generated constructor stub
        mMsg = msg;
    }
    public String getMsg(){
        return mMsg;
    }
}
