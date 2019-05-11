package com.xpzones.base;

import java.io.Serializable;

public class BaseModel<T> implements Serializable {
    public int status;// -1 访问异常 1 访问成功 2 访问失败
    public int errorCode;
    public String msg;
    public T result;
    public String cartId;
    public T data;
}

