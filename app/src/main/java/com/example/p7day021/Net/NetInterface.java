package com.example.p7day021.Net;

import java.util.HashMap;

public interface NetInterface {
    <T> void get(String url,NetCallBack<T> callBack);
    <T> void post(String url,NetCallBack<T> callBack);
    <T> void post(String url, HashMap<String,String> map, NetCallBack<T> callBack);
}
