package com.yoga.farmer.net.retrofit;

import com.yoga.farmer.net.respose.ResCrop;
import com.yoga.farmer.net.respose.ResCropVariety;
import com.yoga.farmer.net.respose.ResDistrict;
import com.yoga.farmer.net.respose.ResFarmList;
import com.yoga.farmer.net.respose.ResLogin;
import com.yoga.farmer.net.respose.ResMessage;
import com.yoga.farmer.net.respose.ResState;
import com.yoga.farmer.net.respose.ResTaluka;
import com.yoga.farmer.net.respose.ResVillage;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TNService {

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/authentication/login")
    Call<ResLogin> login(
            @Field("mobile") String mobile, @Field("password") String password,
            @Field("deviceId") String deviceNo, @Field("versionNo") String versionNo
    );


    /*
    * "{
	""full_name"": ""sandeep naskar"",
	""mobile"": 9049558659,
	""email"":""sandeep1@gmail.com"",
	""password"":""password"",
	""state_id"":""2"",
	""district_id"":""1"",
	""taluka_id"":""1"",
	""village_id"":""1""
}"
    * */
    @FormUrlEncoded
    @POST("/desktopmodules/services/api/MobileApp/SignUpDsij_DSIJ")
    Call<ResMessage> signUp(
            @Field("full_name") String full_name,
            @Field("mobile") String mobile,
            @Field("email") String email,
            @Field("password") String phone,
            @Field("state_id") long state_id,
            @Field("district_id") long district_id,
            @Field("taluka_id") long taluka_id,
            @Field("village_id") long village_id,
            @Field("VersionNo") String version,
            @Field("appid") int appId
    );
    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getState")
    Call<ResState> getState(
            @Field("mobile") String mobile
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getState")
    Call<ResVillage> getVillage(
            @Field("mobile") String mobile,
            @Field("id") long id
    );
    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getState")
    Call<ResDistrict> getDistrict(
            @Field("mobile") String mobile,
            @Field("id") long id
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getState")
    Call<ResTaluka> getTaluka(
            @Field("mobile") String mobile,
            @Field("id") long id
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getCrop")
    Call<ResCrop> getCrops(
            @Field("user_id") long user_id,
            @Field("langId") long LangId
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/farm/getCropDetail")
    Call<ResCropVariety> getCropDetail(
            @Field("user_id") long user_id,
            @Field("crop_id") long cropId,
            @Field("langId") long langId
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/Farm/getFarmList")
    Call<ResFarmList> getFarmList(
            @Field("user_id") long user_id,
            @Field("lang_id") long LangId
    );

    @FormUrlEncoded
    @POST("/sandeep/index.php/api/Farm/registerFarm")
    Call<ResMessage> registerFarm(
            @Field("user_id") long user_id,
            @Field("farm_name") String farm_name,
            @Field("farm_area") String farm_area,
            @Field("crop_id") long crop_id,
            @Field("crop_detail_id") long crop_detail_id,
            @Field("plot_no") String plot_no,
            @Field("season_id") long season_id,
            @Field("soil_type") String soil_type,
            @Field("is_water") int is_water,
            @Field("is_soil_examined") int is_soil_examined,
            @Field("soil_content_n") String soil_content_n,
            @Field("soil_content_p") String soil_content_p,
            @Field("soil_content_k") String soil_content_k,
            @Field("soil_content_other_name") String soil_content_other_name,
            @Field("soil_content_other_value") String soil_content_other_value,
            @Field("start_date") String start_date,
            @Field("survey_no") String survey_no,
            @Field("lang_id") long LangId
    );
}
