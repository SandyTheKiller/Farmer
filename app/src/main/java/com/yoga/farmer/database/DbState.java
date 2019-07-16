package com.yoga.farmer.database;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DbState extends RealmObject {

    /*  ""id"": ""1"",
        ""state_name"": ""Maharashtra"",
        ""created_dtm"": ""2019-06-04 23:33:27"",
        ""updated_dtm"": null,
        ""lang_id"": ""1""
        */

    @PrimaryKey
    private long id;
    private String state_name;
    private long lang_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public long getLang_id() {
        return lang_id;
    }

    public void setLang_id(long lang_id) {
        this.lang_id = lang_id;
    }
}
