package com.lsy.module_home;

import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.bean.EventBusBean;
import com.lsy.lib_base.data.EvenBusMsg;
import com.lsy.lib_base.data.JavaBean;
import com.lsy.lib_base.provider.IFindModuleService;
import com.lsy.lib_base.router_service.ModuleRouteService;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.utils.UIUtils;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class HomeFragmentTest extends BaseFragment implements View.OnClickListener {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;

    @Override
    public int getLayoutId() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_home_test;
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
        qmuiTopBarLayout.addLeftImageButton(R.mipmap.ic_list, 0).setOnClickListener(new View.OnClickListener() {
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
            Uri uri = Uri.parse("arouter://com.lsy/me/main/EventBus");
            String scheme = uri.getScheme();
            Log.e("scheme-----------", scheme);
            String schemeSpecificPart = uri.getSchemeSpecificPart();
            Log.e("schemeSpecificPart-----", schemeSpecificPart);
//            String fragment = uri.getFragment();
//            Log.e("fragment-----", fragment);
            String authority = uri.getAuthority();
            Log.e("authority-----", authority);
            String path = uri.getPath();
            Log.e("path-----", path);
//            String query = uri.getQuery();
//            Log.e("query-------", query);
            String host = uri.getHost();
            Log.e("host-----", host);
            Integer port = uri.getPort();
            Log.e("port--------", port.toString());


            Uri testUriMix = Uri.parse("arouter://com.lsy/me/main/EventBus");
            ARouter.getInstance().build(testUriMix)
                    .withString("name", "haungxiaoguo")
                    .withLong("age", 25)
                    .withParcelable("eventbus", eventBusBean)
                    .navigation();
        } else if (view.getId() == R.id.oldVersionAnim) {
            //旧版本转场动画
            ARouter.getInstance().build(RouterUtils.ME_TEST)
                    .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                    .navigation(mActivity);//上下文不传没有效果
        } else if (view.getId() == R.id.newVersionAnim) {
            //新版本转场动画
            if (Build.VERSION.SDK_INT >= 16) {
                ActivityOptionsCompat compat = ActivityOptionsCompat.
                        makeScaleUpAnimation(view, view.getWidth() / 2, view.getHeight() / 2, 0, 0);
                ARouter.getInstance().build(RouterUtils.ME_WEBVIEW).withOptionsCompat(compat)
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
            } else {
                ARouter.getInstance().build(RouterUtils.ME_WEBVIEW)
                        .withString("url", "file:///android_asset/schame-test.html")
                        .navigation();
            }

        } else if (view.getId() == R.id.navByUrl) {
            //通过URL跳转（webview）
            ARouter.getInstance()
                    .build(RouterUtils.ME_WEBVIEW)
                    .withString("url", "file:///android_asset/schame-test.html")
                    .navigation();
        } else if (view.getId() == R.id.interceptor) {
            //如果利用重新分组，就需要在build中进行指定的分组不然没有效果
            ARouter.getInstance().build(RouterUtils.ME_TEST2, "needLogin")
                    .navigation(getContext(), new NavCallback() {
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
                            Log.e("lsy", "没有找到");
                        }

                        @Override
                        public void onArrival(Postcard postcard) {
                            //路由到达之后调用
                            Log.e("lsy", "跳转成功");
                        }

                        @Override
                        public void onInterrupt(Postcard postcard) {
                            super.onInterrupt(postcard);
                            //路由被拦截时调用
                            Log.e("lsy", "拦截了");
                        }
                    });

        } else if (view.getId() == R.id.interceptor1) {
            ARouter.getInstance().build(RouterUtils.NEEDLOGIN_TEST3)
                    .navigation();
        } else if (view.getId() == R.id.interceptor2) {
            //拦截器操作(绿色通道，跳过拦截器)
            ARouter.getInstance().build(RouterUtils.NEEDLOGIN_TEST3)
                    .withString("extra", "我是绿色通道直接过来的，不经过拦截器")
                    .greenChannel()
                    .navigation();
        } else if (view.getId() == R.id.autoInject) {
            /**
             * 没有序列化过得
             * 必须先初始化JsonServiceImpl实现SerializationService
             */
            EventBusBean eventBusBean = new EventBusBean();
            eventBusBean.setProject("android");
            eventBusBean.setNum(3);
            //普通的javaBean
            JavaBean javaBean = new JavaBean();
            javaBean.setName("lsy");
            javaBean.setAge(25);

            List<JavaBean> objList = new ArrayList<>();
            objList.add(javaBean);
            Map<String, List<JavaBean>> map = new HashMap<>();
            map.put("testMap", objList);

            ARouter.getInstance().build(RouterUtils.ME_INJECT)
                    .withString("name", "老王")
                    .withInt("age", 18)
                    .withBoolean("boy", true)
                    .withLong("high", 180)
                    .withString("url", "https://www.baidu.com")
                    .withParcelable("pac", eventBusBean)
                    .withObject("obj", javaBean)
                    .withObject("objList", objList)
                    .withObject("map", map)
                    .navigation();

        } else if (view.getId() == R.id.btn_use_other_module) {
            //模块间服务调用
            //例如home模块调用find模块的方法
            String userName = ModuleRouteService.getUserName("userId");
            UIUtils.showToast(userName);
        } else if (view.getId() == R.id.btn_use_other_module_by_name) {
            //模块间通过路径名称调用服务
            IFindModuleService iFindModuleService = (IFindModuleService) ARouter.getInstance().build(RouterUtils.FIND_SERVICE).navigation();
            String userName = iFindModuleService.getUserName("userId");
            UIUtils.showToast(userName);

        } else if (view.getId() == R.id.btn_use_other_module_by_type) {
            //模块间通过类名调用服务
            IFindModuleService iFindModuleService = ARouter.getInstance().navigation(IFindModuleService.class);
            String userName = iFindModuleService.getUserName("userId");
            UIUtils.showToast(userName);
        } else if (view.getId() == R.id.failNav) {
            //跳转失败
            ARouter.getInstance().build("/xxx/xxx").navigation(getContext(), new NavCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    UIUtils.showToast("找到了");
                }

                @Override
                public void onLost(Postcard postcard) {
                    UIUtils.showToast("找不到了");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    UIUtils.showToast("跳转完了");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    UIUtils.showToast("被拦截了");
                }
            });
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
        UIUtils.showToast(evenBusMsg.toString());
    }
}
