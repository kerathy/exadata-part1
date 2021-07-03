package com.example.srsproject;

import com.example.srsproject.guest.GuestInfo;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HotelApi {


    @GET("records")
    Call<List<HotelModel>> getRecords();

    @FormUrlEncoded
    @POST("posts")
    Call<HotelModel> createRecord(@FieldMap Map<String, String> fields);
}
