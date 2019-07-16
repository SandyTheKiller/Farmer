package com.yoga.farmer.net.retrofit;

import com.yoga.farmer.constants.C;
import com.yoga.farmer.database.DbDsijUser;
import com.yoga.farmer.net.respose.ResCrop;
import com.yoga.farmer.net.respose.ResCropVariety;
import com.yoga.farmer.net.respose.ResDistrict;
import com.yoga.farmer.net.respose.ResFarmList;
import com.yoga.farmer.net.respose.ResLogin;
import com.yoga.farmer.net.respose.ResMessage;
import com.yoga.farmer.net.respose.ResState;
import com.yoga.farmer.net.respose.ResTaluka;
import com.yoga.farmer.net.respose.ResVillage;


import io.realm.Realm;
import retrofit2.Call;


public class CallGenerator {

    public static String currentUserName;
    public static String portfolioid;
    public static String token;
    public static long userId;

    public static String currentUserName() {
        Realm realm = Realm.getDefaultInstance();
        DbDsijUser currentUser = realm.where(DbDsijUser.class).findFirst();

        try {
            currentUserName = currentUser.getUsername();
            token=currentUser.getSessionToken();
            userId=currentUser.getUserId();
            portfolioid=currentUser.getPortfolioId();
        } catch (Exception e) {
            currentUserName = null;
        } finally {
            realm.close();
        }

        return currentUserName;
    }


    public static long currentUserId() {
        Realm realm = Realm.getDefaultInstance();
        DbDsijUser currentUser = realm.where(DbDsijUser.class).findFirst();
        long userId = 0;

        try {
            userId = currentUser.getUserId();
        } catch (Exception e) {
            userId = 0;
        } finally {
            realm.close();
        }

        return userId;
    }
    public static Call<ResMessage> signUp(String name,String mobileNo, String password, long stateId,long districtId,long talukaId,long villageId) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.signUp(name,mobileNo, "",password, stateId,districtId,talukaId,villageId,C.device.VERSION_CODE,C.device.APP_ID);
    }
    public static Call<ResLogin> login(String mobileNo, String password) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.login(mobileNo, password, C.device.DEVICE_SERIAL, C.device.VERSION_CODE);
    }
    public static Call<ResState> getState() {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getState("asasas");
    }
    public static Call<ResDistrict> getDistrict(long id) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getDistrict("asasas",id);
    }
    public static Call<ResTaluka> getTaluka(long id) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getTaluka("asasas",id);
    }
    public static Call<ResVillage> getVillage(long id) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getVillage("asasas",id);
    }

    public static Call<ResCrop> getCrops() {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getCrops(getUserId(),1);
    }

    public static Call<ResCropVariety> getCropDetail(long id,long langId) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getCropDetail(getUserId(),id,langId);
    }

    public static Call<ResMessage> registerFarm(String farm_name,String farm_area,long crop_id,long crop_detail_id,String plot_no,long season_id,String soil_type,
                                                int is_water,int is_soil_examined,String soil_content_n,String soil_content_p,String soil_content_k,
                                                String soil_content_other_name,String soil_content_other_value,String start_date,String survey_no) {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.registerFarm(2, farm_name,farm_area,crop_id,crop_detail_id,plot_no,season_id,soil_type,is_water,is_soil_examined, soil_content_n, soil_content_p,
                soil_content_k,soil_content_other_name,soil_content_other_value,start_date,survey_no,1);
    }

    public static Call<ResFarmList> getFarmList() {
        TNService tnService = ServiceGenerator.createServiceLocal(TNService.class);
        return tnService.getFarmList(getUserId(), 1);
    }
    private static long getUserId() {
        return 1;
    }

    private static String getMobile() {
        return "";
    }
}
