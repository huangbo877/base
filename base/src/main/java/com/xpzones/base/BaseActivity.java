package com.xpzones.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.xpzones.base.base.R;
import com.xpzones.bean.Event;
import com.xpzones.utils.EventBusUtils;
import com.xpzones.utils.KeyboardUtils;
import com.xpzones.utils.LogUtil;
import com.xpzones.utils.ToastUtils;
import com.xpzones.widget.ActionBar;
//import com.xpzones.widget.dialog.LoadingDialog;
//import com.xuexiang.xui.utils.WidgetUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 * Created by Administrator on 2017/7/5.
 */

public abstract class BaseActivity extends FragmentActivity implements CustomAdapt {
    private Unbinder unbinder;
    private ViewStub emptyView;
    protected Context mContext;
    protected ImmersionBar mImmersionBar;
//    protected LoadingDialog loadingDialog;
    private ActionBar aBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        if (isActionBar()) {
            setContentView(R.layout.base_activity);
            ((ViewGroup) findViewById(R.id.fl_content)).addView(getLayoutInflater().inflate(getLayoutId(), null));
            aBar = (ActionBar) findViewById(R.id.actionbar);
        } else {
            setContentView(getLayoutId());
        }
        BaseApplication.getApplication().getActivityManage().addActivity(this);
        //初始化ButterKnife
        unbinder = ButterKnife.bind(this);
        //沉浸式状态栏
        mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(false).fitsSystemWindows(true).statusBarColor(R.color.abar);
        mImmersionBar.init();
        //加入Activity管理器
        BaseApplication.getApplication().getActivityManage().addActivity(this);
        if (regEvent()) {
            EventBusUtils.register(this);
        }
//        loadingDialog = new LoadingDialog(mContext);


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public ActionBar getaBar() {
        return aBar;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if (regEvent()) {
            EventBusUtils.unregister(this);
        }
        //必须调用该方法，防止内存泄漏
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
//        if (mLoadingDialog != null) {
//            mLoadingDialog.recycle();
//        }
        //将Activity从管理器移除
        BaseApplication.getApplication().getActivityManage().removeActivity(this);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initView();
    }

    /**
     * 子类接受事件 重写该方法
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBus(Event event) {
    }

    public void hintKbTwo() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive() && getCurrentFocus() != null) {
            if (getCurrentFocus().getWindowToken() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    @Override
    public void finish() {
        hintKbTwo();
        super.finish();

    }

    /**
     * 需要接收事件 重写该方法 并返回true
     */
    protected boolean regEvent() {
        return false;
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

//    com.xuexiang.xui.widget.dialog.LoadingDialog mLoadingDialog;

    public void showLoad() {
//        if (mLoadingDialog == null) {
//            mLoadingDialog = WidgetUtils.getLoadingDialog(this)
//                    .setIconScale(0)
//                    .setLoadingIcon(null)
//                    .setLoadingSpeed(8);
//        }
//        mLoadingDialog.show();
    }

    public void dissLoad() {
//        if (mLoadingDialog != null) {
//            mLoadingDialog.dismiss();
//        }
    }

    /**
     * 显示吐司
     *
     * @param msg
     */
    public void showToast(String msg) {
        ToastUtils.showToast(this, msg);
    }

    /**
     * 显示log
     *
     * @param msg
     */
    public void showLog(String msg) {
        LogUtil.Log(msg);
    }

    //***************************************空页面方法*************************************
    protected void showEmptyView(String text) {
        showEmptyOrErrorView(text, R.drawable.bg_no_data);
    }

    protected void showEmptyView() {
        showEmptyView(getString(R.string.no_data));
    }

    protected void showErrorView(String text) {
        showEmptyOrErrorView(text, R.drawable.bg_no_net);
    }

    protected void showErrorView() {
        showErrorView(getString(R.string.error_data));
    }

    public void showEmptyOrErrorView(String text, int img) {
        emptyView = findViewById(R.id.vs_empty);

        if (emptyView != null) {
            emptyView.setVisibility(View.VISIBLE);
            findViewById(R.id.iv_empty).setBackgroundResource(img);
            ((TextView) findViewById(R.id.tv_empty)).setText(text);
            findViewById(R.id.ll_empty).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPageClick();
                }
            });
        }
    }

    protected void hideEmptyView() {
        if (emptyView != null) {
            emptyView.setVisibility(View.GONE);
        }
    }

    /**
     * 空页面被点击
     */
    protected void onPageClick() {

    }

    /**
     * 是否需要ActionBar
     * TODO 暂时用此方法 后续优化
     */
    protected boolean isActionBar() {
        return false;
    }

    //***************************************空页面方法*********************************
    @Override
    public boolean isBaseOnWidth() {
        return true;
    }

    /**
     * 这里使用 iPhone 的设计图, iPhone 的设计图尺寸为 750px * 1334px, 高换算成 dp 为 667 (1334px / 2 = 667dp)
     * <p>
     * 返回设计图上的设计尺寸, 单位 dp
     * {@link #getSizeInDp} 须配合 {@link #isBaseOnWidth()} 使用, 规则如下:
     * 如果 {@link #isBaseOnWidth()} 返回 {@code true}, {@link #getSizeInDp} 则应该返回设计图的总宽度
     * 如果 {@link #isBaseOnWidth()} 返回 {@code false}, {@link #getSizeInDp} 则应该返回设计图的总高度
     * 如果您不需要自定义设计图上的设计尺寸, 想继续使用在 AndroidManifest 中填写的设计图尺寸, {@link #getSizeInDp} 则返回 {@code 0}
     *
     * @return 设计图上的设计尺寸, 单位 dp
     */
    @Override
    public float getSizeInDp() {
        return 375;
    }
}
