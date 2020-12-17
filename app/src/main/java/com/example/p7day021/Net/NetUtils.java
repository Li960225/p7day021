package com.example.p7day021.Net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class NetUtils implements NetInterface {
    private static volatile NetUtils netUtils;
    private final ApiService apiService;

    public NetUtils() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        apiService = new Retrofit.Builder()
                .baseUrl(NetConstant.BASEALLURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    public static NetUtils getNetUtils() {
        if (netUtils == null){
            synchronized (NetUtils.class){
                if (netUtils == null){
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    @Override
    public <T> void get(String url, NetCallBack<T> callBack) {
        apiService.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = types[0];
                            callBack.OnSuccess(new Gson().fromJson(string,type));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, NetCallBack<T> callBack) {

    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, NetCallBack<T> callBack) {

    }
}
