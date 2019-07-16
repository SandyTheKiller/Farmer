package com.yoga.farmer;

import android.content.Context;
import android.content.SharedPreferences;

import com.yoga.farmer.model.User;
import com.yoga.farmer.model.logindata.Response;


/**
 * Created by pradipp on 09-Jan-18.
 */

public class SharedPrefManager {
    public static final String KEY_USER_NAME = "";
    private static final String SHARED_PREF_NAME = "xoxyvirtue";
    private static final String KEY_USER_ID = "keyuserid";
    private static final String KEY_USER_EMAIL = "keyuseremail";
    private static final String KEY_USER_PASSWORD = "password";
    private static final String KEY_USER_TYPE = "usertype";
    private static final String TAG_TOKEN = "tagtoken";
    private static final String KEY_COMMENT = "comment";
    private static SharedPrefManager mInstance;
    private static Context mCtx;


    public SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLogin(Response user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USER_ID, user.getId());
        editor.putString(KEY_USER_NAME, user.getUsername());
        editor.putString(KEY_USER_EMAIL, user.getMobilenumber());
        editor.putString(KEY_USER_PASSWORD, user.getPassword());
       // editor.putString(KEY_USER_TYPE, user.getUser_type());
        //editor.putString(KEY_USER_GENDER, user.getGender());
        editor.apply();
        return true;
    }

    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USER_EMAIL, null) != null)
            return true;
        return false;
    }



   /* public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_USER_ID, 0),
                sharedPreferences.getString(KEY_USER_NAME, null),
                sharedPreferences.getString(KEY_USER_EMAIL, null),
                sharedPreferences.getString(KEY_COMMENT, null)
        );
    }*/

    /*  public Response getResponse() {
          SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
          return new Response(
                  sharedPreferences.getInt(KEY_USER_ID1,0),
                  sharedPreferences.getString(KEY_USER_NAME1, null),
                  sharedPreferences.getString(KEY_USER_EMAIL1, null),
                  sharedPreferences.getString(KEY_USER_MOBILE, null),
                  sharedPreferences.getString(KEY_USER_TYPE, null)

          );
      }
  */
    public boolean logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
 /*   public int retrieveMessageCount(){
        return mInstance.getInt(Constants.MESSAGE_COUNT, 0);
    }*/
 //this method will save the device token to shared preferences
 public boolean saveDeviceToken(String token) {
     SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
     SharedPreferences.Editor editor = sharedPreferences.edit();
     editor.putString(TAG_TOKEN, token);
     editor.apply();
     return true;
 }

    //this method will fetch the device token from shared preferences
    public String getDeviceToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TAG_TOKEN, null);
    }
    public User getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt(KEY_USER_ID, 0),
                sharedPreferences.getString(KEY_USER_NAME, null),
                sharedPreferences.getString(KEY_USER_EMAIL, null),
                sharedPreferences.getString(KEY_COMMENT, null)
        );
    }
}
