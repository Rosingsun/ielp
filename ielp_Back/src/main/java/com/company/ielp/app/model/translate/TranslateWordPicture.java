package com.company.ielp.app.model.translate;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * 翻译单词与图片对应关系
 * @author 幕冬儿
 */
public class TranslateWordPicture {

    @TableId(type= IdType.AUTO)
    private Integer id;
    private String word;
    private String pictureUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "TranslateWordPicture{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
