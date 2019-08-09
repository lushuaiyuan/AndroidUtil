package com.lsy.androidutils;

import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.lsy.androidutils.base.BaseActivity;
import com.lsy.androidutils.find.FindFragment;
import com.lsy.androidutils.home.HomeFragment;
import com.lsy.androidutils.message.MessageFragment;
import com.lsy.androidutils.mine.MineFragment;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseActivity {
    @BindView(R.id.navigationBar)
    EasyNavigationBar navigationBar;


    private String[] tabText = {"首页", "发现", "消息", "我"};
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
        initBottomBar();
    }

    private void initBottomBar() {
        fragments.add(new HomeFragment());
        fragments.add(new FindFragment());
        fragments.add(new MessageFragment());
        fragments.add(new MineFragment());
        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .lineHeight(1)
                .lineColor(ContextCompat.getColor(this, R.color.bar_divider))
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        return false;
                    }
                })
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .canScroll(true)
//                .navigationHeight(50)
                .anim(Anim.ZoomIn)

                .build();
        // ((WeiboActivity) getActivity()).getNavigationBar().selectTab(1); //指定跳转位置
        //TODO 设置小红点和消息
        navigationBar.setMsgPointCount(0, 109);
        navigationBar.setMsgPointCount(3, 5);

        navigationBar.setHintPoint(1, true);

        //移除消息和小红点
//        navigationBar.clearHintPoint(position);//移除指定位置的小红点
//        navigationBar.clearAllHintPoint();//移除所有的小红点
//        navigationBar.clearMsgPoint(position);//移除指定位置的消息
//        navigationBar.clearAllMsgPoint();//移除所有的消息
    }

    public EasyNavigationBar getNavigationBar() {
        return navigationBar;
    }

}

