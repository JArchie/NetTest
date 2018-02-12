package com.archie.library.retrofit;

import java.util.Map;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by Jarchie on 2017\12\7.
 * Http发起的几种请求的封装
 */

public interface RestService {

    //Get请求
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    //Post请求
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    //Post原始数据
    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    //Put请求
    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

    //Put原始数据
    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    //Delete请求
    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    //文件下载
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    //文件上传
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);

}
