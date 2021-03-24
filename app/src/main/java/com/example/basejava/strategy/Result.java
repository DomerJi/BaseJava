package com.example.basejava.strategy;

import android.os.Message;

/**
 * Created by v_jishuaipeng on 2019-09-11.
 * 描述:
 */
public class Result {

    public int code = 0;
    public String msg;
    public Worker worker;

    public boolean isSuccess(){
        return code == 0;
    }

}
