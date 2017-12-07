package com.archie.library.retrofit.callback;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.retrofit.callback
 * 文件名:   IRequest
 * 创建者:   Jarchie
 * 创建时间: 17/12/3 下午10:04
 * 描述:     处理请求开始和结束的回调
 */

public interface IRequest {

    void onRequestStart();

    void onRequestEnd();
}
