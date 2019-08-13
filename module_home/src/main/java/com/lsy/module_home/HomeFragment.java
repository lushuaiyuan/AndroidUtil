package com.lsy.module_home;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.base.BaseFragment;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@Route(path = RouterUtils.HOME_FRAGMENT_MAIN)
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        initTopBar();
    }


    private void initTopBar() {
        Log.e("HomeFragment----", "initTopBar()");
        qmuiTopBarLayout.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.app_color_theme_2));
        qmuiTopBarLayout.setTitleGravity(Gravity.LEFT);
        qmuiTopBarLayout.setTitle("收件箱");
        qmuiTopBarLayout.setSubTitle("lsy_itsports@163.com");
        qmuiTopBarLayout.addLeftImageButton(R.mipmap.icon_list, 0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mActivity, "侧边栏", Toast.LENGTH_SHORT).show();
            }
        });
        View view = LayoutInflater.from(mActivity).inflate(R.layout.view_home_right, null);
        ImageButton ibFilter = view.findViewById(R.id.ib_filter);
        ibFilter.setOnClickListener(this);
        ImageButton ibSearch = view.findViewById(R.id.ib_search);
        ibSearch.setOnClickListener(this);
        ImageButton ibAdd = view.findViewById(R.id.ib_add);
        ibAdd.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(WRAP_CONTENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        qmuiTopBarLayout.addRightView(view, R.id.home_right, layoutParams);
    }


    @OnClick(R2.id.btn)
    public void viewClick(View view) {
        // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
//        ARouter.getInstance().build(Constant.URL_TEST).navigation(mActivity, 100);


        // 2. 跳转并携带参数
        ARouter.getInstance().build(RouterUtils.URL_TEST)
                .withLong("key1", 666L)
                .withString("key2", "888")
                .navigation(mActivity, 100);

    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ib_add) {
            Toast.makeText(mActivity, "添加", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.ib_filter) {
            Toast.makeText(mActivity, "过滤", Toast.LENGTH_SHORT).show();
        }
        if (view.getId() == R.id.ib_search) {
            Toast.makeText(mActivity, "查询", Toast.LENGTH_SHORT).show();
        }
    }
}
