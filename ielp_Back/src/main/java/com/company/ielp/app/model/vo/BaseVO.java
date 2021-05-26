package com.company.ielp.app.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseVO {
    private int state;
    private String msg;
    private Date time;

    public final static int SUCCESS = 200;
    public final static int NOT_FOUND = 404;
    public final static int INTERNAL_SERVER_ERROR = 500;

    public BaseVO() {
        time = new Date();
    }

    public BaseVO(String msg, int state) {
        this.msg = msg;
        this.state = state;
        time = new Date();
    }

}