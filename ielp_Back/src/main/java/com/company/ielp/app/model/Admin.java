package com.company.ielp.app.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admin {
    private Integer id;
    private String adminName;
    private String adminPassWord;
}
