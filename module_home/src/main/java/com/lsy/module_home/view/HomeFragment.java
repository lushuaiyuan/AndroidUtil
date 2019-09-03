package com.lsy.module_home.view;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.lsy.lib_base.base.BaseMvpFragment;
import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.lib_base.bean.BannerBean;
import com.lsy.lib_base.bean.FriendBean;
import com.lsy.lib_base.bean.HotkeyBean;
import com.lsy.lib_base.bean.Optional;
import com.lsy.lib_base.utils.GlideImageLoader;
import com.lsy.lib_base.utils.RouterUtils;
import com.lsy.lib_base.base.BaseFragment;
import com.lsy.lib_base.utils.UIUtils;
import com.lsy.lib_net.response.ResponseData;
import com.lsy.module_home.R;
import com.lsy.module_home.R2;
import com.lsy.module_home.adapter.ArticleAdapter;
import com.lsy.module_home.contract.HomeContract;
import com.lsy.module_home.presenter.HomePresenter;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

@Route(path = RouterUtils.HOME_FRAGMENT_MAIN)
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View, View.OnClickListener {
    @BindView(R2.id.topbar)
    QMUITopBarLayout qmuiTopBarLayout;
    @BindView(R2.id.banner)
    Banner mBanner;
    @BindView(R2.id.mRecycleView)
    RecyclerView mRecycleView;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        mPresenter = new HomePresenter();
        mPresenter.attachView(this);
        initTopBar();
        mPresenter.bannerList();

    }

    private void initTopBar() {
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

        mRecycleView.setLayoutManager(new LinearLayoutManager(mActivity));
        ArticleAdapter articleAdapter = new ArticleAdapter()
        mRecycleView
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


    @Override
    public void onSuccess1(Optional<List<BannerBean>> bannerResponseData) {
        List<BannerBean> includeNull = bannerResponseData.getIncludeNull();
        List<String> images = new ArrayList<>();
        for (int i = 0; i < includeNull.size(); i++) {
            images.add(includeNull.get(i).getImagePath());
        }
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();

        mPresenter.articleList(0);
    }

    @Override
    public void onSuccess2(Optional<ArticleBean> articleResponseData) {
        ArticleBean articleBean = articleResponseData.getIncludeNull();
        List<ArticleBean.Article> datas = articleBean.getDatas();


    }

    @Override
    public void onSuccess3(Optional<List<HotkeyBean>> hotKeyResponseData) {

    }

    @Override
    public void onSuccess4(Optional<List<FriendBean>> friendResponseData) {

    }
}
