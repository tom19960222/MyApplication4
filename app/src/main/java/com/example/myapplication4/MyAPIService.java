package com.example.myapplication4;

import java.util.Map;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyAPIService {
    @GET("product/{id}")
    Call<product> getProduct(@Path("id") int id);

    @GET("productName")
    Call<ResponseBody> getProductName();


    @GET("productList")
    Call<ResponseBody> getProductList();


    @FormUrlEncoded
    @POST("feedback/{Uid}/{Pid}")
    Call<feedback> feedback(@Path("Uid") int Uid, @Path("Pid") int Pid , @Field("feedback") String feedback);


}
