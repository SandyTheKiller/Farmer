package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResVillage {

private List<ResVillage.VillageEntity> list;

    public List<VillageEntity> getList() {
        return list;
    }

    public void setList(List<VillageEntity> list) {
        this.list = list;
    }

    public static class VillageEntity {
        private long id;
        private long taluka_id;
        private String village_name;
        private long lang_id;

        public long getTaluka_id() {
            return taluka_id;
        }

        public void setTaluka_id(long taluka_id) {
            this.taluka_id = taluka_id;
        }

        public String getVillage_name() {
            return village_name;
        }

        public void setVillage_name(String village_name) {
            this.village_name = village_name;
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
