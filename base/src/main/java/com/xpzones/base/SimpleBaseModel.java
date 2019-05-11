package com.xpzones.base;

import java.io.Serializable;

public class SimpleBaseModel implements Serializable {
    public int status = 0;
    public String msg = "no data";

    public BaseModel toBaseModel() {
        BaseModel base = new BaseModel();
        base.status = status;
        base.msg = msg;
        return base;
    }
}
