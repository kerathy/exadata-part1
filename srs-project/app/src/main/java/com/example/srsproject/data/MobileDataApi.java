package com.example.srsproject.data;

import com.example.srsproject.GuestInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface JsonApi {

    @FormUrlEncoded
    @POST("posts")
    Call<GuestInfo> createPost(@FieldMap Map<String, String> fields);
}
