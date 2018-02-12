package com.archie.library.retrofit.callback;

import android.support.annotation.NonNull;

import com.archie.library.ui.DialogLoader;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jarchie on 2017\12\7.
 * Retrofit处理请求的回调
 */

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final Class<?> CLASS;

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error, Class<?> clazz) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.CLASS = clazz;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    if (CLASS != null) {
                        Object object = new Gson().fromJson(response.body(), CLASS);
                        SUCCESS.onSuccess(object);
                    } else {
                        SUCCESS.onSuccess(response.body());
                    }
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        DialogLoader.dismiss();
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }
        DialogLoader.dismiss();
    }

}
