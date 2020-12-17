package com.example.p7day021.Model;

import com.example.p7day021.Contract.BannerContarct;
import com.example.p7day021.Net.NetCallBack;
import com.example.p7day021.Net.NetUtils;
import com.example.p7day021.Presenter.BannerPresenterImp;

public class BannerModelImp implements BannerContarct.IBannerModel {
    private BannerPresenterImp bannerPresenterImp;

    public BannerModelImp(BannerPresenterImp bannerPresenterImp) {
        this.bannerPresenterImp = bannerPresenterImp;
    }

    @Override
    public <T> void getData(String url, NetCallBack<T> callBack) {
        NetUtils.getNetUtils().get(url,callBack);
    }
}
