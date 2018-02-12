package com.archie.library.retrofit;

import android.content.Context;

import com.archie.library.retrofit.callback.IError;
import com.archie.library.retrofit.callback.IFailure;
import com.archie.library.retrofit.callback.IRequest;
import com.archie.library.retrofit.callback.ISuccess;
import com.archie.library.retrofit.callback.RequestCallbacks;
import com.archie.library.retrofit.download.DownloadHandler;
import com.archie.library.ui.DialogLoader;

import java.io.File;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Jarchie on 2017\12\7.
 * 网络请求的宿主类
 */

@SuppressWarnings({"unused", "WeakerAccess", "FieldCanBeLocal"})
public final class RestClient {

    private final Context CONTEXT;
    private final String URL;
    private final HashMap<String, Object> PARAMS;
    private final RequestBody BODY;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final Class<?> CLASS;
    private final File FILE; //文件
    private final String DOWNLOAD_DIR; //文件目录
    private final String EXTENSION; //后缀名
    private final String NAME; //文件名

    public RestClient(Context context, String url, HashMap<String, Object> params,
                      RequestBody body, IRequest request,
                      ISuccess success, IFailure failure, IError error,
                      Class<?> clazz, File file, String downloadDir,
                      String extension, String name) {
        this.CONTEXT = context;
        this.URL = url;
        this.PARAMS = params;
        this.BODY = body;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.CLASS = clazz;
        this.FILE = file;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
    }

    public static RestClientBuilder Builder() {
        return new RestClientBuilder();
    }

    private void request(String method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        //弹出加载框
        DialogLoader.show(CONTEXT);

        switch (method) { //调起Service中相对应的请求类型
            case HttpMethod.GET: //GET请求
                call = service.get(URL, PARAMS);
                break;
            case HttpMethod.POST: //POST请求
                call = service.post(URL, PARAMS);
                break;
            case HttpMethod.POST_RAW: //POST原始数据
                call = service.postRaw(URL, BODY);
                break;
            case HttpMethod.PUT: //PUT请求
                call = service.put(URL, PARAMS);
                break;
            case HttpMethod.PUT_RAW: //PUT原始数据
                call = service.putRaw(URL, BODY);
                break;
            case HttpMethod.DELETE: //DELETE请求
                call = service.delete(URL, PARAMS);
                break;
            case HttpMethod.UPLOAD: //上传文件
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                call = service.upload(URL, body);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    //获取处理回调的方法
    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR, CLASS);
    }

    /*****************以下方法在建造者模式构建完成时调用，用于具体发起相对应的请求**************/

    //GET请求
    public final void get() {
        request(HttpMethod.GET);
    }

    //POST请求
    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }
    }

    //PUT请求
    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
    }

    //DELETE请求
    public final void delete() {
        request(HttpMethod.DELETE);
    }

    //上传文件
    public final void upload() {
        request(HttpMethod.UPLOAD);
    }

    //下载文件
    public final void download() {
        new DownloadHandler(URL, PARAMS, REQUEST, DOWNLOAD_DIR,
                EXTENSION, NAME, SUCCESS, FAILURE, ERROR)
                .handleDownload();
    }

}
