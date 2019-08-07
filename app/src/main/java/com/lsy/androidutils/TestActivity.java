package com.lsy.androidutils;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.utils.Constant;
import com.qmuiteam.qmui.widget.QMUITopBar;

import butterknife.BindView;


@Route(path = Constant.URL_TEST)
public class TestActivity extends BaseActivity {

    @BindView(R.id.topbar)
    QMUITopBar topBar;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @Autowired
    long key1;
    @Autowired
    String key2;
    @Autowired
    Test key3;

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public void init() {
        topBar.setBackgroundColor(ContextCompat.getColor(this, R.color.app_color_theme_4));
        topBar.setTitle("测试");
        topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        topBar.addRightImageButton(R.mipmap.icon_qq, R.id.qq).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "点击QQ", Toast.LENGTH_SHORT).show();
            }
        });

        View root = LayoutInflater.from(this).inflate(R.layout.view_right, null);
        RelativeLayout.LayoutParams layoutParams = topBar.generateTopBarImageButtonLayoutParams();
        topBar.addRightView(root, R.id.share, layoutParams);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "点击了分享", Toast.LENGTH_SHORT).show();
            }
        });
        tvContent.setText("参数是： " + "key1: " + key1 + "  key2: " + key2 + " key3：" + key3.toString());
    }
}
