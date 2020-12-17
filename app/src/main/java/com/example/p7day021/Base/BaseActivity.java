package com.example.p7day021.Base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.p7day021.Presenter.BannerPresenterImp;
import com.example.p7day021.R;

public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity implements BaseView {
    protected p presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        if (presenter == null){
            presenter = getPresenter();
        }
        initView();
        initData();
    }

    protected abstract p getPresenter();

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView();
}
