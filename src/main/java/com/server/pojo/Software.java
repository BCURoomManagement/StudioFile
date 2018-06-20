package com.server.pojo;

public class Software {
    private int s_id;
    private int u_id;
    private String s_name;
    private String s_time;
    private String s_software;
    private String s_version;

    //不是数据库数据
    private String s_username;

    public String getS_username() {
        return s_username;
    }

    public void setS_username(String s_username) {
        this.s_username = s_username;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getS_software() {
        return s_software;
    }

    public void setS_software(String s_software) {
        this.s_software = s_software;
    }

    public String getS_version() {
        return s_version;
    }

    public void setS_version(String s_verson) {
        this.s_version = s_verson;
    }
}
