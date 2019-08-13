package com.lsy.androidutil;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.lsy.lib_base.base.BaseActivity;

import butterknife.BindView;

public class LaunchActivity extends BaseActivity {
    private static final int sleepTime = 2000;
    @BindView(R.id.mSplashRoot)
    ImageView mSplashRoot;
    @Override
    public int getLayoutId() {
        return R.layout.activity_launch;
    }

    @Override
    public void init() {
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(1500);
        mSplashRoot.startAnimation(animation);
    }
    @Override
    protected void onStart() {
        super.onStart();
        new Thread(new Runnable() {
            public void run() {
                long start = System.currentTimeMillis();
                long costTime = System.currentTimeMillis() - start;
                //wait
                if (sleepTime - costTime > 0) {
                    try {
                        Thread.sleep(sleepTime - costTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        }).start();

    }
}
