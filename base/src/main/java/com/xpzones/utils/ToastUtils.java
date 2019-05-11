package com.xpzones.utils;

import android.content.Context;
import android.view.Gravity;
//import android.widget.Toast;

import com.dovar.dtoast.DToast;
import com.xpzones.base.base.R;

public class ToastUtils {

    public static void showToast(Context context, int strings) {
        showToast(context, context.getString(strings));
    }

    public static void showToast(Context context, String text) {
//        showToast(context, title, Gravity.BOTTOM);
        //使用默认布局
        DToast.make(context)
                .setText(R.id.tv_content_default, text)
                .setGravity( Gravity.CENTER, 0, 0)
                .showLong();

//通过setView()设置自定义的Toast布局
//        DToast.make(mContext)
//                .setView(View.inflate(mContext, R.layout.layout_toast_center, null))
//                .setText(R.id.tv_content_custom, msg)
//                .setGravity(Gravity.CENTER, 0, 0)
//                .showLong();
//        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 自定义显示Toast弹出提示框
     *
     * @param s       s
     * @param gravity 弹出位置
     */

    public static void showToast(Context context, CharSequence s, int gravity) {
//        Toast toast = new Toast(context);
//        View toastView = View.inflate(context, R.layout.toast, null);
//        toast.setView(toastView);
//        toast.setDuration(Toast.LENGTH_SHORT);
//        TextView textView = toastView.findViewById(R.id.tv_message);
//        textView.setText(s);
//        toast.setGravity(gravity, 0, 100);
//        toast.show();
    }
}
