package com.company.ielp.app.model.dto;

import com.company.ielp.app.model.entity.TranslateCollection;
import com.company.ielp.app.model.entity.TranslateHistory;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 翻译主类，包含了一条翻译记录的所有信息。
 *
 * @author 幕冬儿
 * @see TranslateCollection
 * @see TranslateHistory
 */
@Data
@ToString
public class TranslateDTO {

        private Integer id;

        private String languageFrom;

        private String languageTo;

        private String translatedWord;

        private String picUrl;

        private Date createTime;

        private Date updateTime;

        private Boolean isCollection;
}
