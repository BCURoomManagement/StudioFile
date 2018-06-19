package com.server.pojo;

public class Competition {
    private int c_id;
    private int u_id;
    private String  c_time;
    private String  c_word;
    private String c_code;
    private String c_name;
    private String c_certificate; //证书
    private String  c_video;

    public String getC_video() {
        return c_video;
    }

    public void setC_video(String c_video) {
        this.c_video = c_video;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getC_word() {
        return c_word;
    }

    public void setC_word(String c_word) {
        this.c_word = c_word;
    }

    public String getC_code() {
        return c_code;
    }

    public void setC_code(String c_code) {
        this.c_code = c_code;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_certificate() {
        return c_certificate;
    }

    public void setC_certificate(String c_certificate) {
        this.c_certificate = c_certificate;
    }
}
