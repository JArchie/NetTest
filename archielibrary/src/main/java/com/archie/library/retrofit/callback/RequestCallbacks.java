package com.archie.library.retrofit.callback;

import android.os.Handler;

import com.archie.library.ui.DialogLoader;
import com.archie.library.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.retrofit.callback
 * 文件名:   RequestCallbacks
 * 创建者:   Jarchie
 * 创建时间: 17/12/4 下午9:41
 * 描述:     Retrofit处理请求的回调
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailed FAILDE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success,
                            IFailed failed, IError error,
                            LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILDE = failed;
        this.ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) { //response执行成功
            if (call.isExecuted()) { //call已经执行了
                if (SUCCESS != null) { //回调成功的方法
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else { //不成功，即失败时
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        stopLoading();
    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {
        if (FAILDE != null) {
            FAILDE.onFailed();
        }
        if (REQUEST != null) { //请求结束时的回调
            REQUEST.onRequestEnd();
        }

        stopLoading();
    }

    private void stopLoading() {
        if (LOADER_STYLE != null) {
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    DialogLoader.stopLoading();
                }
            }, 1000);
        }
    }

}
