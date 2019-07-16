package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResDistrict {

private List<ResDistrict.DistrictEntity> list;

    public List<DistrictEntity> getList() {
        return list;
    }

    public void setList(List<DistrictEntity> list) {
        this.list = list;
    }

    public static class DistrictEntity {
        private long id;
        private long state_id;
        private String district_name;
        private long lang_id;

        public long getState_id() {
            return state_id;
        }

        public void setState_id(long state_id) {
            this.state_id = state_id;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getLang_id() {
            return lang_id;
        }

        public void setLang_id(long lang_id) {
            this.lang_id = lang_id;
        }

    }
}
