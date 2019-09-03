package com.lsy.androidutil;

import android.util.Log;
import android.view.View;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.lsy.lib_base.base.BaseActivity;
import com.lsy.module_find.FindFragment;
import com.lsy.module_home.view.HomeFragment;
import com.lsy.module_me.MineFragment;
import com.lsy.module_message.MessageFragment;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.navigationBar)
    EasyNavigationBar navigationBar;
    private static final String TAG = "MainActivity";

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
                        Log.e(TAG, "onTabClickEvent: position-----" + position);
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
}
