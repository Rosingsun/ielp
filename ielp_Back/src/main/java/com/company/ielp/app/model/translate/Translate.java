package com.company.ielp.app.model.translate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Translate {
    @TableId(type= IdType.AUTO)
    protected Integer id;
    protected String languageFrom;
    protected String languageTo;
    protected String translatedWords;
    protected Date translatedTime;
    protected String picUrl;
    protected Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageFrom() {
        return languageFrom;
    }

    public void setLanguageFrom(String languageFrom) {
        this.languageFrom = languageFrom;
    }

    public String getLanguageTo() {
        return languageTo;
    }

    public void setLanguageTo(String languageTo) {
        this.languageTo = languageTo;
    }

    public String getTranslatedWords() {
        return translatedWords;
    }

    public void setTranslatedWords(String translatedWords) {
        this.translatedWords = translatedWords;
    }

    public Date getTranslatedTime() {
        return translatedTime;
    }

    public void setTranslatedTime(Date translatedTime) {
        this.translatedTime = translatedTime;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Translate{" +
                "id=" + id +
                ", languageFrom='" + languageFrom + '\'' +
                ", languageTo='" + languageTo + '\'' +
                ", translatedWords='" + translatedWords + '\'' +
                ", translatedTime=" + translatedTime +
                ", picUrl='" + picUrl + '\'' +
                ", userId=" + userId +
                '}';
    }
}
