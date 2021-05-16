package com.company.ielp.app.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class BaseVO {
    private String state;
    private String msg;
    private Date time;
}
