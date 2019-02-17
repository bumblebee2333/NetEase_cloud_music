package com.example.selflayout.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.selflayout.BaseActivity;
import com.example.selflayout.R;

public class SongListActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentLayout(R.layout.activity_music_menu);//设置到BaseActivity中的content中

        setTitle("歌单");//设置标题
        setBackArrow();//设置返回按钮和点击事件
    }

    //    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            moveTaskToBack(false);
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
