package com.archie.library.retrofit.callback;

/**
 * Created by Jarchie on 2017\12\7.
 * 处理请求开始和结束的回调接口
 */

public interface IRequest {
    //请求开始
    void onRequestStart();

    //请求结束
    void onRequestEnd();
}
