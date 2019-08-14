package com.lsy.module_me.view;

import android.view.View;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseActivity;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.module_me.R;
import com.lsy.module_me.R2;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import butterknife.BindView;

@Route(path = RouterUtils.ME_WEBVIEW)
public class WebViewActivity extends BaseActivity {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.webview)
    WebView mWebView;
    @Autowired
    String url;

    @Override
    public int getLayoutId() {
        return R.layout.activity_webview;
    }

    @Override
    public void init() {
        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mWebView.loadUrl(url);
    }
}
