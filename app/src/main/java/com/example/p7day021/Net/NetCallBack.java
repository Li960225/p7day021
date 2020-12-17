package com.example.p7day021.Net;

import com.example.p7day021.Bean.BannerBean;

import java.util.List;

public interface NetCallBack<T> {
    void OnSuccess(T t);
    void OnFail(String error);
}
