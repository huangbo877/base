/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xpzones.net.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;
//import com.xuexiang.xui.utils.WidgetUtils;

/**
 * ================================================
 * 作    者：jeasonlzy（廖子尧）
 * 版    本：1.0
 * 创建日期：2016/4/8
 * 描    述：我的Github地址  https://github.com/jeasonlzy
 * 修订历史：
 * ================================================
 */
public abstract class StringDialogCallback extends StringCallback {



//    com.xuexiang.xui.widget.dialog.LoadingDialog mLoadingDialog;

    public  StringDialogCallback(Context activity) {
//        if (mLoadingDialog == null) {
//            mLoadingDialog = WidgetUtils.getLoadingDialog(activity)
//                    .setIconScale(0)
//                    .setLoadingIcon(null)
//                    .setLoadingSpeed(8);
//        }
//        mLoadingDialog.show();
    }

    @Override
    public void onBefore(BaseRequest request) {
        super.onBefore(request);
//        if (mLoadingDialog != null && !mLoadingDialog.isShowing()) {
//            mLoadingDialog.show();
//        }
    }

    @Override
    public void onAfter(String s, Exception e) {
        super.onAfter(s, e);
//        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
//            mLoadingDialog.dismiss();
//            mLoadingDialog.recycle();
//        }
    }


}
