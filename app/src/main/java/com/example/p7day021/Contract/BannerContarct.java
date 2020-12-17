package com.example.p7day021.Contract;

import com.example.p7day021.Bean.BannerBean;
import com.example.p7day021.Net.NetCallBack;

import java.util.List;

public class BannerContarct {
    public interface IBannerView{
        void OnSuccess(List<BannerBean.BannerlistBean> bannerlistBeans);
        void OnFail(String error);
    }

    public interface IBannerModel{
        <T> void getData(String url, NetCallBack<T> callBack);
    }

    public interface IBannerPresenter{
        void getBannerData();
    }
}
