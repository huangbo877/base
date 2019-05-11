package com.xpzones.utils;


import com.xpzones.base.base.BuildConfig;
import com.xpzones.constants.Constants;

/**
 * 日志打印类，打印统一在这里处理
 */
public class LogUtil {
    public static final boolean hasLog = BuildConfig.DEBUG;
    public static final String TAG = Constants.Log_TAG;

    /**
     * @param tag
     * @param paramString
     */
    public static void Log(String tag, String paramString) {
        if (hasLog)
            android.util.Log.w(tag, paramString);
    }

    public static void Log(String paramString) {
        Log(TAG, paramString);
    }

    public static void ErrorLog(Exception e) {
        ErrorLog(TAG, e);
    }

    public static void ErrorLog(String tag, Exception e) {
        if (hasLog)
            android.util.Log.e(tag, "", e);
    }

    public static void e(String paramString) {
        if (hasLog)
            android.util.Log.e(TAG, paramString);
    }
}
