package com.lsy.module_home;

import android.net.Uri;
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
import com.lsy.lib_base.bean.EventBusBean;
import com.lsy.lib_base.data.EvenBusMsg;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.utils.UIUtils;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@Route(path = RouterUtils.HOME_FRAGMENT_MAIN)
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_home;
    }

    @Override
    public void onDestroyView() {
        EventBus.getDefault().unregister(this);
        super.onDestroyView();
    }

    @Override
    public void initData() {
        initView();
        initTopBar();
    }

    private void initView() {
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


    @OnClick({R2.id.btn_goto_login, R2.id.btn_eventbus, R2.id.btn_uri, R2.id.oldVersionAnim, R2.id.newVersionAnim, R2.id.navByUrl, R2.id.interceptor, R2.id.interceptor1, R2.id.interceptor2, R2.id.autoInject
            , R2.id.btn_use_other_module, R2.id.btn_use_other_module_by_name, R2.id.btn_use_other_module_by_type, R2.id.failNav})
    public void viewClick(View view) {
        if (view.getId() == R.id.btn_goto_login) {   //登录（跨模块跳转Activity）
            ARouter.getInstance().build(RouterUtils.ME_LOGIN).navigation();
        } else if (view.getId() == R.id.btn_eventbus) {
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setProject("android");
            eventBusBean.setNum(3);
            ARouter.getInstance().build(RouterUtils.ME_EVENTBUS)
                    .withString("name", "lsy")
                    .withInt("age", 25)
                    .withParcelable("eventbus", eventBusBean)
                    .navigation();
        } else if (view.getId() == R.id.btn_uri) {
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setProject("android");
            eventBusBean.setNum(3);

            Uri testUriMix = Uri.parse("arouter://com.lsy/me/main/EventBus");
            ARouter.getInstance().build(testUriMix)
                    .withString("name", "haungxiaoguo")
                    .withLong("age", 25)
                    .withParcelable("eventbus", eventBusBean)
                    .navigation();
        } else if (view.getId() == R.id.oldVersionAnim) {

        } else if (view.getId() == R.id.newVersionAnim) {

        } else if (view.getId() == R.id.navByUrl) {

        } else if (view.getId() == R.id.interceptor) {

        } else if (view.getId() == R.id.interceptor1) {

        } else if (view.getId() == R.id.interceptor2) {

        } else if (view.getId() == R.id.autoInject) {

        } else if (view.getId() == R.id.btn_use_other_module) {

        } else if (view.getId() == R.id.btn_use_other_module_by_name) {

        } else if (view.getId() == R.id.btn_use_other_module_by_type) {

        } else if (view.getId() == R.id.failNav) {

        }


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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EvenBusMsg evenBusMsg) {
        UIUtils.ToastMsg(evenBusMsg.toString());
    }
}
