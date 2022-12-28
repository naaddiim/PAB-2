package com.example.badutfirebase;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIEndpoint {
    // Register User
    @POST("registers")
    @FormUrlEncoded
    Call<ResponseData<BearerToken>> register (@Field("name") String name,
                                             @Field("email") String email,
                                             @Field("password") String password,
                                             @Field("password_confirmation") String password_confirmation);
}
