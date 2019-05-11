package com.xpzones.net.callback;

/**
 * Created by RedWhite on 2017/10/30.
 */

public abstract class XZoneNetCallBack<T> {

    public abstract void onSucceed(T t);

    public abstract void onFailed(String msg);
}
