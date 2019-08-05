package com.lsy.androidutils;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindString(R.string.app_name)
    String app_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn)
    public void viewClick() {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//        ARouter.getInstance().build("/test/activity").navigation(this, 100);

        // 2. 跳转并携带参数
        ARouter.getInstance().build("/test/activity")
                .withLong("key1", 666L)
                .withString("key3", "888")
                .withParcelable("key4", new Test("Jack", "Rose"))
                .navigation(this,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            Toast.makeText(this, app_name, Toast.LENGTH_LONG).show();
        }
    }
}

