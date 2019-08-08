package com.lsy.androidutils;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.find.FindFragment;
import com.lsy.androidutils.home.HomeFragment;
import com.lsy.androidutils.message.MessageFragment;
import com.lsy.androidutils.mine.MineFragment;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.topbar)
    QMUITopBarLayout topBar;
    @BindView(R.id.navigationBar)
    EasyNavigationBar navigationBar;


    private String[] tabText = {"首页", "发现", "消息", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.home_normal, R.mipmap.find_normal, R.mipmap.message_normal, R.mipmap.mine_normal};
    //选中时icon
    private int[] selectIcon = {R.mipmap.home_press, R.mipmap.find_press, R.mipmap.message_press, R.mipmap.mine_press};

    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        topBar.setTitle(tabText[0]);

        topBar.addLeftImageButton(R.mipmap.icon_back, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "返回", Toast.LENGTH_SHORT).show();
            }
        });
        topBar.addRightImageButton(R.mipmap.icon_share, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "分享", Toast.LENGTH_SHORT).show();
            }
        });
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(true)
                .navigationHeight(48)
                .build();
    }

}

