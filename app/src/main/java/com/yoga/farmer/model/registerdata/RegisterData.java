package com.yoga.farmer.model.registerdata;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.yoga.farmer.model.logindata.Response;


/**
 * Created by pradip
 */

public class RegisterData {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private com.yoga.farmer.model.logindata.Response response;

    RegisterData(String e, String m, Response res)
    {
        this.error=e;
        this.message=m;
        this.response=res;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Response getResponse() {
        return response;
    }
}
