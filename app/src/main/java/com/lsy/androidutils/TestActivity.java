package com.lsy.androidutils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alibaba.android.arouter.utils.Consts.TAG;


@Route(path = "/test/activity")
public class TestActivity extends Activity {
    @BindView(R.id.tv_content)
    TextView tvContent;
//    @Autowired
//    long key1;
//    @Autowired
//    String key3;
//    @Autowired
//    String key4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        long key1 = intent.getLongExtra("key1", 0);
        String key3 = intent.getStringExtra("key3");
        tvContent.setText("参数是： " + "key1: " + key1 + "  key3: " + key3);
    }
}
