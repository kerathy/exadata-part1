package com.example.srsproject.room;

import java.util.Map;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HotelApi {

    @FormUrlEncoded
    @POST("posts")
    Call<HotelModel> createRecord(@FieldMap Map<String, String> fields);
}
