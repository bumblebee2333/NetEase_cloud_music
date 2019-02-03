package com.example.selflayout;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.selflayout.Fragment.MainFragment;
import com.example.selflayout.Fragment.MusicFragment;
import com.example.selflayout.Fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView title_one;
    private ImageView title_two;
    private ImageView title_three;
    private List<Fragment> fragments = new ArrayList<>();
    int lastIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragments();
        setFragmentPosition(1);
    }

    private void initView(){
        title_one = findViewById(R.id.note);
        title_two = findViewById(R.id.cloud);
        title_three = findViewById(R.id.player);
        title_one.setOnClickListener(this);
        title_two.setOnClickListener(this);
        title_three.setOnClickListener(this);
    }

    private void initFragments(){
        fragments.add(MusicFragment.newInstance());
        fragments.add(MainFragment.newInstance());
        fragments.add(VideoFragment.newInstance());
    }

    private void setFragmentPosition(int position){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = fragments.get(position);
        Fragment lastFragment = fragments.get(lastIndex);
        lastIndex = position;
        ft.hide(lastFragment);
        if(!currentFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
            ft.add(R.id.main_container,currentFragment);
        }
        ft.show(currentFragment);
        ft.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.note)
            setFragmentPosition(0);
        else if(v.getId() == R.id.cloud)
            setFragmentPosition(1);
        else if(v.getId() == R.id.player)
            setFragmentPosition(2);
    }
}
