package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResCropVariety {

    /*
    * {
        "id": "1",
        "crop_name": "sugarcane",
        "lang_id": null,
        "created_dtm": null,
        "updated_dtm": null
    }

     "id": "2",
            "season_id": "2",
            "crop_id": "5",
            "sub_crop_name": "Punjab no. 13",
    * */
private List<CropEntity> list;

    public List<CropEntity> getList() {
        return list;
    }

    public void setList(List<CropEntity> list) {
        this.list = list;
    }

    public static class CropEntity {
        private long crop_detail_id;
        private String sub_crop_name;
        private long lang_id;
        private long crop_id;

        public long getCrop_detail_id() {
            return crop_detail_id;
        }

        public void setCrop_detail_id(long crop_detail_id) {
            this.crop_detail_id = crop_detail_id;
        }

        public String getSub_crop_name() {
            return sub_crop_name;
        }

        public void setSub_crop_name(String sub_crop_name) {
            this.sub_crop_name = sub_crop_name;
        }

        public long getCrop_id() {
            return crop_id;
        }

        public void setCrop_id(long crop_id) {
            this.crop_id = crop_id;
        }

        public long getLang_id() {
            return lang_id;
        }

        public void setLang_id(long lang_id) {
            this.lang_id = lang_id;
        }
    }
}
