package com.example.selflayout.Tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

//Intent跳转封装
public class IntentUtil {
    private static IntentUtil manager;
    private static Intent intent;

    private IntentUtil(){

    }

    public static IntentUtil get(){
        if(manager == null){
            synchronized (IntentUtil.class){
                if(manager == null){
                    manager = new IntentUtil();
                }
            }
        }
        intent = new Intent();
        return manager;
    }

    //启动一个Activity
    public void goActivity(Context _this, Class<? extends Activity> _class){
        intent.setClass(_this,_class);
        _this.startActivity(intent);
        _this = null;
    }
}
