package com.acorn.mvpdemo;

/**
 * Created by acorn on 2020/3/30.
 */
public interface BaseView<T> {
    void setPresenter(T presenter);
}
