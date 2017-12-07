package com.archie.library.retrofit;

import android.content.Context;

import com.archie.library.retrofit.callback.IError;
import com.archie.library.retrofit.callback.IFailed;
import com.archie.library.retrofit.callback.IRequest;
import com.archie.library.retrofit.callback.ISuccess;
import com.archie.library.ui.LoaderStyle;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 项目名:   NetTest
 * 包名:     com.archie.library.retrofit
 * 文件名:   RestClientBuilder
 * 创建者:   Jarchie
 * 创建时间: 17/12/3 下午9:49
 * 描述:     网络请求的建造者类
 */

public final class RestClientBuilder {
    private String mUrl = null;
    private static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailed mIFailed = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;
    private File mFile = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
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

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failed(IFailed iFailed) {
        this.mIFailed = iFailed;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallGridPulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, mDownloadDir, mExtension, mName, PARAMS, mIRequest, mISuccess, mIFailed, mIError, mBody, mFile, mContext, mLoaderStyle);
    }

}
