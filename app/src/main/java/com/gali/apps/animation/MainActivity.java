package com.gali.apps.animation;

import android.content.res.Resources;
import android.support.annotation.IdRes;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    float binX;
    float binY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.trashBtn).setOnClickListener(this);
        findViewById(R.id.sketchBtn).setOnClickListener(this);
        findViewById(R.id.baloonBtn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.trashBtn:
                fragment = new TrashFragment();
                break;
            case R.id.sketchBtn:
                fragment = new SketchFragment();
                break;
            case R.id.baloonBtn:
                fragment = new BaloonFragment();
                break;
        }
        if (fragment!=null)
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
    }
}
