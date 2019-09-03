package com.lsy.module_me.view;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.heima.easysp.SharedPreferencesUtils;
import com.lsy.lib_base.RouterApplication;
import com.lsy.lib_base.base.BaseMvpActivity;
import com.lsy.lib_base.bean.LoginBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_base.utils.ProgressDialog;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.utils.UIUtils;
import com.lsy.lib_net.NetWorkManager;
import com.lsy.lib_base.exception.ApiException;
import com.lsy.lib_net.response.ResponseTransformer;
import com.lsy.lib_net.schedulers.SchedulerProvider;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.lsy.module_me.contract.LoginContract;
import com.lsy.module_me.presenter.LoginPresenter;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

/**
 * 登录模块
 */
@Route(path = RouterUtils.ME_LOGIN)
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.View {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.et_username)
    EditText etUserName;
    @BindView(R2.id.et_password)
    EditText etPassword;

    @BindView(R2.id.path)
    TextView mTvPath;

    @Autowired(name = "path", required = true, desc = "登录成功要跳转的页面")
    String loginBackPath;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTvPath.setText(loginBackPath);
    }

    @OnClick({R2.id.btn_login})
    public void viewClick(View view) {
        if (view.getId() == R.id.btn_login) {
            mPresenter.login(etUserName.getText().toString(), etPassword.getText().toString());
        }
    }

    @Override
    public void onSuccess(Optional<LoginBean> loginResponseData) {
        SharedPreferencesUtils.init(RouterApplication.getmContext()).put("nickName", loginResponseData.getIncludeNull().getNickname());
        //登录成功之后继续跳转到登录之前请求的页面
        if (loginBackPath != null && loginBackPath != "") {
            ARouter.getInstance().build(loginBackPath).navigation();
        }
        LoginActivity.this.finish();
    }
}
