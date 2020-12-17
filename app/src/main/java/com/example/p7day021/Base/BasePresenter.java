package com.example.p7day021.Base;

public class BasePresenter<V extends BaseView> {
    private V iView;
    public void attachView(V v){
        iView = v;
    }
}
