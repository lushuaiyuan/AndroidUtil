package com.lsy.lib_base.base;

import androidx.lifecycle.Lifecycle;

import com.lsy.lib_base.exception.ApiException;
import com.lsy.lib_base.utils.ProgressDialog;
import com.lsy.lib_base.utils.UIUtils;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    protected T mPresenter;

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        ProgressDialog.getInstance().show(this);
    }

    @Override
    public void hideLoading() {
        ProgressDialog.getInstance().dismiss();
    }

    @Override
    public void onError(Throwable throwable) {
        hideLoading();
        if (throwable instanceof ApiException) {
            UIUtils.showToast(((ApiException) throwable).getDisplayMessage());
        } else {
            UIUtils.showToast(throwable.getMessage());
        }
    }

    /**
     * 绑定生命周期 防止MVP内存泄漏
     *
     * @param <T>
     * @return
     */
    @Override
    public <T> AutoDisposeConverter<T> bindAutoDispose() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY));
    }
}
