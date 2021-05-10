package com.company.ielp.app.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Admin {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String adminName;
    private String passWord;
}
