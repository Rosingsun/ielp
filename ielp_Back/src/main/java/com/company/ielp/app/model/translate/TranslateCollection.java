package com.company.ielp.app.model.translate;

import java.util.Date;

/**
 * 用户收藏，继承自Translate，新增收藏时间
 * @author 幕冬儿
 * @see Translate
 */
public class TranslateCollection extends Translate {

    public TranslateCollection() {
    }

    public TranslateCollection(Translate translate) {
        this.id = translate.id;
        this.languageFrom = translate.languageFrom;
        this.languageTo = translate.languageTo;
        this.translatedWords = translate.translatedWords;
        this.translatedTime = translate.translatedTime;
        this.picUrl = translate.picUrl;
        this.userId = translate.userId;
    }

    private Date collectionTime;

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public String toString() {
        return "TranslateCollection{" +
                "id=" + id +
                ", languageFrom='" + languageFrom + '\'' +
                ", languageTo='" + languageTo + '\'' +
                ", translatedWords='" + translatedWords + '\'' +
                ", translatedTime=" + translatedTime +
                ", picUrl='" + picUrl + '\'' +
                ", userId=" + userId +
                ", collectionTime='" + collectionTime + '\'' +
                '}';
    }
}
