package com.example.p7day021.Presenter;

import com.example.p7day021.Base.BasePresenter;
import com.example.p7day021.Bean.BannerBean;
import com.example.p7day021.Contract.BannerContarct;
import com.example.p7day021.MainActivity;
import com.example.p7day021.Model.BannerModelImp;
import com.example.p7day021.Net.NetCallBack;
import com.example.p7day021.Net.NetConstant;

public class BannerPresenterImp extends BasePresenter<MainActivity> implements BannerContarct.IBannerPresenter {
    private BannerContarct.IBannerView iBannerView;
    private BannerContarct.IBannerModel iBannerModel;

    public BannerPresenterImp(BannerContarct.IBannerView iBannerView) {
        iBannerModel = new BannerModelImp(this);
        this.iBannerView = iBannerView;
    }

    @Override
    public void getBannerData() {
        iBannerModel.getData(NetConstant.BASEBANNERURL, new NetCallBack<BannerBean>() {
            @Override
            public void OnSuccess(BannerBean bannerBean) {
                iBannerView.OnSuccess(bannerBean.getBannerlist());
            }

            @Override
            public void OnFail(String error) {
                iBannerView.OnFail(error);
            }
        });
    }
}
