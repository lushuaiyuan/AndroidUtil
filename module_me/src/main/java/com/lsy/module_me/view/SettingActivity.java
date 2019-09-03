package com.lsy.module_me.view;

import android.content.Intent;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.heima.easysp.SharedPreferencesUtils;
import com.lsy.lib_base.RouterApplication;
import com.lsy.lib_base.base.BaseMvpActivity;
import com.lsy.lib_base.bean.LogOutBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.utils.UIUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.lsy.module_me.contract.SettingContract;
import com.lsy.module_me.presenter.SettingPresenter;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterUtils.ME_SETTING)
public class SettingActivity extends BaseMvpActivity<SettingPresenter> implements SettingContract.View {
    @BindView(R2.id.tv_logout)
    TextView tvLogout;
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    @OnClick(R2.id.tv_logout)
    public void viewClick() {
        new QMUIDialog.MessageDialogBuilder(this)
                .setMessage("是否退出登录")
                .addAction("确定", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(final QMUIDialog dialog, int index) {
                        mPresenter.logOut();
                    }
                })
                .addAction("取消", new QMUIDialogAction.ActionListener() {
                    @Override
                    public void onClick(QMUIDialog dialog, int index) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true).show();
    }

    @Override
    public void init() {
        mPresenter = new SettingPresenter();
        mPresenter.attachView(this);
        qmuiTopBarLayout.setTitle("设置");
    }

    @Override
    public void onSuccess(Optional<LogOutBean> logoutResponseData) {
        UIUtils.showToast("退出成功");
        SharedPreferencesUtils.init(RouterApplication.getmContext()).clear();
        startActivity(new Intent(SettingActivity.this, LoginActivity.class));
        finish();
    }
}
