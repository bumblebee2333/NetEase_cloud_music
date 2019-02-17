package com.example.selflayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class BaseActivity extends AppCompatActivity {
    //通用的Toolbar标题
    private TextView commonTitleTv;
    //通用的ToolBar
    private Toolbar commonTitleTb;
    //内容区域
    private FrameLayout content;
    //右上角的图标
    private ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initView();
        setSupportActionBar(commonTitleTb);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    private void initView(){
        commonTitleTv = findViewById(R.id.commom_title);
        commonTitleTb = findViewById(R.id.toolbar);
        content = findViewById(R.id.content);
        img = findViewById(R.id.commom_img);
    }

    //子类调用 重新设置Toolbar
    public void setToolBar(int layout){
        hidetoolBar();
        commonTitleTb = content.findViewById(layout);
        setSupportActionBar(commonTitleTb);
        //设置actionbar标题是否显示 对应ActionBar.DISPLAY_SHOW_TITLE
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    //隐藏Toolbar 通过setToolbar重新制定Toolbar
    public void hidetoolBar(){
        commonTitleTb.setVisibility(View.GONE);
    }

    //menu的点击事件
    public void setToolBarMenuOnClick(Toolbar.OnMenuItemClickListener onClick){
        commonTitleTb.setOnMenuItemClickListener(onClick);
    }

    //设置左上角back按钮
    public void setBackArrow(){
        final Drawable upArrow = getResources().getDrawable(R.drawable.back);
        //给Toolbar设置左侧的图标
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //设置返回按钮的点击事件
        commonTitleTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //设置右上角的图标
    public void setRightImagine(@DrawableRes int imgId){
        img.setImageResource(imgId);
    }

    //设置toolbar下面内容区域的内容
    public void setContentLayout(int layoutId){
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(layoutId,null);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        content.addView(contentView,params);
    }

    //设置标题
    public void setTitle(String title){
        if(!TextUtils.isEmpty(title)){
            commonTitleTv.setText(title);
        }
    }

    //设置标题
    public void setTitle(int resId){
        commonTitleTv.setText(resId);
    }
}
