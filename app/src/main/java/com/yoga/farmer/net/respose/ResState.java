package com.yoga.farmer.net.respose;

import java.util.List;

/**
 * Created by Sandip on 9/12/2017.
 */

public class ResState {

private List<StateEntity> list;

    public List<StateEntity> getList() {
        return list;
    }

    public void setList(List<StateEntity> list) {
        this.list = list;
    }

    public static class StateEntity {
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
}
