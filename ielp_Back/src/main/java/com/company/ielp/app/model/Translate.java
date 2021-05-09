package com.company.ielp.app.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Translate {

    @TableId(type=IdType.AUTO)
    public Integer id;

    public String languageFrom;
    public String languageTo;

    public String translatedWords;
    public Date translatedTime;

    public String picUrl;
    public Integer userId;
}