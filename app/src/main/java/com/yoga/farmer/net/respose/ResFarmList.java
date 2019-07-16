package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResFarmList {

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
        private String farm_name;
        private String farm_area;
        private String start_date;
        private String crop_name;
        private String sub_crop_name;
        private long crop_detail_id;
        private long season_id;
        private long lang_id;
        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getFarm_name() {
            return farm_name;
        }

        public void setFarm_name(String farm_name) {
            this.farm_name = farm_name;
        }

        public String getFarm_area() {
            return farm_area;
        }

        public void setFarm_area(String farm_area) {
            this.farm_area = farm_area;
        }

        public String getCrop_name() {
            return crop_name;
        }

        public void setCrop_name(String crop_name) {
            this.crop_name = crop_name;
        }

        public String getSub_crop_name() {
            return sub_crop_name;
        }

        public void setSub_crop_name(String sub_crop_name) {
            this.sub_crop_name = sub_crop_name;
        }

        public long getCrop_detail_id() {
            return crop_detail_id;
        }

        public void setCrop_detail_id(long crop_detail_id) {
            this.crop_detail_id = crop_detail_id;
        }

        public String getStart_date() {
            return start_date;
        }

        public void setStart_date(String start_date) {
            this.start_date = start_date;
        }

        public long getSeason_id() {
            return season_id;
        }

        public void setSeason_id(long season_id) {
            this.season_id = season_id;
        }

        public long getLang_id() {
            return lang_id;
        }

        public void setLang_id(long lang_id) {
            this.lang_id = lang_id;
        }
    }
}
