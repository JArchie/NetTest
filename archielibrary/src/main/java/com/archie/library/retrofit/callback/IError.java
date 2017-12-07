package com.archie.library.retrofit.callback;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.retrofit.callback
 * 文件名:   IErroe
 * 创建者:   Jarchie
 * 创建时间: 17/12/3 下午9:59
 * 描述:     错误的回调方法
 */

public interface IError {

    void onError(int code,String msg);
}
