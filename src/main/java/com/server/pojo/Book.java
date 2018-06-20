package com.server.pojo;

public class Book {
    private int b_id;
    private String b_name;
    private int b_status;
    private String b_provide;
    private int u_id;
    private int w_id;

    //不在数据库中
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getW_id() {
        return w_id;
    }

    public void setW_id(int w_id) {
        this.w_id = w_id;
    }

    public int getB_status() {
        return b_status;
    }

    public void setB_status(int b_status) {
        this.b_status = b_status;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }


    public String getB_provide() {
        return b_provide;
    }

    public void setB_provide(String b_provide) {
        this.b_provide = b_provide;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
}
