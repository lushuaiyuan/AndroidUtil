package com.lsy.module_me.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.utils.UIUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录模块
 */
@Route(path = RouterUtils.ME_LOGIN)
public class LoginActivity extends BaseActivity {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.btn_forResult)
    Button mBtnForResult;
    @BindView(R2.id.interceptor)
    Button mBtnInterceptor;
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
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mTvPath.setText(loginBackPath);

    }

    @OnClick({R2.id.btn_forResult, R2.id.interceptor})
    public void viewClick(View view) {
        if (view.getId() == R.id.btn_forResult) {
            ARouter.getInstance().build(RouterUtils.FIND_FORESULT).navigation(this, 666);
        } else if (view.getId() == R.id.interceptor) {
            /**
             * 路由拦截
             */
            ARouter.getInstance()
                    .build(RouterUtils.FIND_INTERCEPTOR)
                    .navigation(this, new NavCallback() {
                        @Override
                        public void onFound(Postcard postcard) {
                            super.onFound(postcard);
                            //路由目标被发现时调用
                            Log.e("lsy", "发现了");
                        }

                        @Override
                        public void onLost(Postcard postcard) {
                            super.onLost(postcard);
                            //路由被丢失时调用
                            Log.e("lsy", "丢失了");
                        }

                        @Override
                        public void onArrival(Postcard postcard) {
                            //路由到达之后调用
                            Log.e("lsy", "到达了");
                        }

                        @Override
                        public void onInterrupt(Postcard postcard) {
                            super.onInterrupt(postcard);
                            //路由被拦截时调用
                            Log.e("lsy", "拦截了");
                        }
                    });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666 && resultCode == 999) {
            String name = data.getStringExtra("name");
            UIUtils.showToast(name + ",resultCode===>" + resultCode);
        }
    }
}
