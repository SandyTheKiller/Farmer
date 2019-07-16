package com.yoga.farmer;


import com.yoga.farmer.model.logindata.LoginData;
import com.yoga.farmer.model.registerdata.RegisterData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/*



import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by pradip on 11/7/2016.
 */
public interface ApiServices {

//Login data response
    @FormUrlEncoded
    @POST("/authentication/user/login")
    Call<LoginData> logincall1(@Field("mobilenumber") String mobilenumber, @Field("password") String password);
    //Register data response
    @FormUrlEncoded
    @POST("/authentication/user")
    Call<RegisterData> registercall(@Field("username") String username, @Field("mobilenumber") String mobilenumber, @Field("password") String password, @Field("country") String country, @Field("state") String state, @Field("district") String district, @Field("taluka") String taluka, @Field("village") String village);
  /*Forgot Password*//*

    @POST(" /authentication/password/forgot/{email}")
    Call<ForgotData> forgotpassword(@Path("email") String email);
    //Courses Data
@Headers({"token:58f2ab6aa5a45c96c0bc191abe24153211746218d2397f16c264be1d0a9fa20cdb25ab2ba585dc72873b874fb3a5abf6"})
    @GET("/content/categories")
    Call<CategoryData> categorycall();
    //Courses Data
    @Headers({"token:58f2ab6aa5a45c96c0bc191abe24153211746218d2397f16c264be1d0a9fa20cdb25ab2ba585dc72873b874fb3a5abf6"})
    @GET("/content/lessons/{cid}")
    Call<LessonData> lessoncall(@Path("cid") int cid);

    @Headers({"token:58f2ab6aa5a45c96c0bc191abe24153211746218d2397f16c264be1d0a9fa20cdb25ab2ba585dc72873b874fb3a5abf6"})
    @GET("/content/lesson/{cid}")
    Call<LessonData> lessonidcall(@Path("cid") int cid);*/
}
