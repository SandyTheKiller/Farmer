package com.yoga.farmer.model.forgotData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotData {
    @SerializedName("error")
    @Expose
    private Boolean error;

    public ForgotData(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
