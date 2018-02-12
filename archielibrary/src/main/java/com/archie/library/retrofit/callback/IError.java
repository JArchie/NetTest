package com.archie.library.retrofit.callback;

/**
 * Created by Jarchie on 2018\2\12.
 * 请求错误的回调
 */

public interface IError {
    //请求错误
    void onError(int code, String msg);
}
