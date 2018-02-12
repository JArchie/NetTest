package com.archie.library.retrofit;

import android.content.Context;
import com.archie.library.retrofit.callback.IError;
import com.archie.library.retrofit.callback.IFailure;
import com.archie.library.retrofit.callback.IRequest;
import com.archie.library.retrofit.callback.ISuccess;
import java.io.File;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Jarchie on 2017\12\7.
 * 网络请求的建造者类
 */

@SuppressWarnings({"unused", "WeakerAccess"})
public final class RestClientBuilder {
    private Context mContext = null;
    private String mUrl = null;
    private HashMap<String, Object> PARAMS = new HashMap<>();
    private RequestBody mBody = null;
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private Class<?> mClass = null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder context(Context context) {
        this.mContext = context;
        return this;
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(HashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder listener(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder listener(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder listener(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder clazz(Class<?> clazz) {
        this.mClass = clazz;
        return this;
    }

    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    public final RestClientBuilder file(String filePath) {
        this.mFile = new File(filePath);
        return this;
    }

    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }

    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mContext, mUrl, PARAMS, mBody, mIRequest, mISuccess, mIFailure, mIError, mClass, mFile, mDownloadDir, mExtension, mName);
    }

}
