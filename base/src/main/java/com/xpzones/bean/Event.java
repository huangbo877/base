package com.xpzones.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event<T> {

    private String action;
    private T data;

    public Event(String action) {
        this.action = action;
    }

    public Event(String action, T data) {
        this.action = action;
        this.data = data;
    }

    public String getAction() {
        return action;
    }

    public T getData() {
        return data;
    }
}
