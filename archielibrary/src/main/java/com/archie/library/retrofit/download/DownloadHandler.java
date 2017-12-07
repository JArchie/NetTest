package com.archie.library.retrofit.download;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.archie.library.retrofit.RestCreator;
import com.archie.library.retrofit.callback.IError;
import com.archie.library.retrofit.callback.IFailed;
import com.archie.library.retrofit.callback.IRequest;
import com.archie.library.retrofit.callback.ISuccess;

import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.retrofit.download
 * 文件名:   DownloadHandler
 * 创建者:   Jarchie
 * 创建时间: 17/12/6 下午4:07
 * 描述:
 */

public class DownloadHandler {

    private final String URL;
    private final WeakHashMap<String, Object> PARAMS;
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;
    private final ISuccess SUCCESS;
    private final IFailed FAILDE;
    private final IError ERROR;

    public DownloadHandler(String url, WeakHashMap<String, Object> params,
                           IRequest request, String downloadDir,
                           String extension, String name,
                           ISuccess success, IFailed failed,
                           IError error) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILDE = failed;
        this.ERROR = error;
    }

    //处理文件下载
    public final void handleDownload() {
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        RestCreator.getRestService().download(URL, PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {

                        if (response.isSuccessful()) { //成功时的回调
                            final ResponseBody responseBody = response.body();
                            final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,
                                    DOWNLOAD_DIR, EXTENSION, responseBody, NAME);

                            //这里一定要注意判断，否则文件下载不全
                            if (task.isCancelled()) {
                                if (REQUEST != null) {
                                    REQUEST.onRequestEnd();
                                }
                            }
                        } else { //错误时的回调
                            if (ERROR != null) {
                                ERROR.onError(response.code(), response.message());
                            }
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        if (FAILDE != null) { //失败时的回调
                            FAILDE.onFailed();
                        }
                    }
                });
    }

}
