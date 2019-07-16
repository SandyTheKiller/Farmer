package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResCrop {

    /*
    * {
        "id": "1",
        "crop_name": "sugarcane",
        "lang_id": null,
        "created_dtm": null,
        "updated_dtm": null
    }
    * */
private List<CropEntity> list;

    public List<CropEntity> getList() {
        return list;
    }

    public void setList(List<CropEntity> list) {
        this.list = list;
    }

    public static class CropEntity {
        private long id;
        private String crop_name;
        private long lang_id;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getCrop_name() {
            return crop_name;
        }

        public void setCrop_name(String crop_name) {
            this.crop_name = crop_name;
        }

        public long getLang_id() {
            return lang_id;
        }

        public void setLang_id(long lang_id) {
            this.lang_id = lang_id;
        }
    }
}
