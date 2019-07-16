package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResTaluka {

private List<ResTaluka.Entity> list;

    public List<Entity> getList() {
        return list;
    }

    public void setList(List<Entity> list) {
        this.list = list;
    }

    public static class Entity {
        private long id;
        private long district_id;
        private String taluka_name;
        private long lang_id;

        public long getDistrict_id() {
            return district_id;
        }

        public void setDistrict_id(long district_id) {
            this.district_id = district_id;
        }

        public String getTaluka_name() {
            return taluka_name;
        }

        public void setTaluka_name(String taluka_name) {
            this.taluka_name = taluka_name;
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
