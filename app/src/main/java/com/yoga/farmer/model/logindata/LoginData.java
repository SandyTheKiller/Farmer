package com.yoga.farmer.model.logindata;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by pradip on 28/12/17.
 */

public class LoginData {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private com.yoga.farmer.model.logindata.Response response;

    public LoginData(Boolean error, String message, Response response) {
        this.error = error;
        this.message = message;
        this.response = response;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(com.yoga.farmer.model.logindata.Response response) {
        this.response = response;
    }
}
