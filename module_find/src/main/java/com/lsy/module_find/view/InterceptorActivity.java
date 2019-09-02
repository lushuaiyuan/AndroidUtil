//package com.lsy.module_find.view;
//
//import android.view.View;
//import android.widget.TextView;
//
//import com.alibaba.android.arouter.facade.annotation.Autowired;
//import com.alibaba.android.arouter.facade.annotation.Route;
//import com.lsy.lib_base.base.BaseActivity;
//import com.lsy.lib_base.utils.RouterUtils;
//import com.lsy.module_find.R;
//import com.lsy.module_find.R2;
//import com.qmuiteam.qmui.widget.QMUITopBarLayout;
//
//import butterknife.BindView;
//
//@Route(path = RouterUtils.FIND_INTERCEPTOR)
//public class InterceptorActivity extends BaseActivity {
//    @BindView(R2.id.topbar)
//    QMUITopBarLayout qmuiTopBarLayout;
//    @BindView(R2.id.textView)
//    TextView mTextView;
//
//    @Autowired
//    String extra;
//
//    @Override
//    public int getLayoutId() {
//        return R.layout.activity_interceptor;
//    }
//
//    @Override
//    public void init() {
//        qmuiTopBarLayout.setTitle("拦截界面");
//        qmuiTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//        mTextView.setText(extra);
//    }
//
//}
