package com.example.p7day021;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7day021.Base.BaseActivity;
import com.example.p7day021.Base.BaseView;
import com.example.p7day021.Bean.BannerBean;
import com.example.p7day021.Contract.BannerContarct;
import com.example.p7day021.Presenter.BannerPresenterImp;

import java.util.List;

public class MainActivity extends BaseActivity<BannerPresenterImp> implements BannerContarct.IBannerView {

    private TextView tvTitle;

    @Override
    protected BannerPresenterImp getPresenter() {
        return new BannerPresenterImp(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    public void initData() {
        presenter.getBannerData();
    }

    public void initView() {
        tvTitle = findViewById(R.id.tv_title);
    }

    @Override
    public void OnSuccess(List<BannerBean.BannerlistBean> bannerlistBeans) {
        tvTitle.setText(bannerlistBeans.get(0).getImageurl());
    }

    @Override
    public void OnFail(String error) {
        tvTitle.setText(error);
    }
}