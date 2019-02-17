package com.example.selflayout.Activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.selflayout.BaseActivity;
import com.example.selflayout.R;

public class RecommendedDailyActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("每日推荐");
        setBackArrow();
        setRightImagine(R.drawable.question);
    }
}
