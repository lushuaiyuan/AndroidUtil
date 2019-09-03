package com.lsy.module_home.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lsy.lib_base.base.BaseView;
import com.lsy.lib_base.bean.ArticleBean;
import com.lsy.module_home.R;

import java.util.List;

public class ArticleAdapter extends BaseQuickAdapter<ArticleBean, BaseViewHolder> {
    public ArticleAdapter( List data) {
        super(R.layout.item_article, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, ArticleBean item) {

    }
}
